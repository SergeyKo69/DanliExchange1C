package com.kogut.danliexchange1c.services.exchange.document;

import com.kogut.danliexchange1c.dto.document.bankstatement.BankStatementDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.document.interfaces.IBankStatementService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 12.08.2021
 */

@Component
public class ExchangeBankStatement implements IExchange<BankStatementDTO> {

    private final ISender<BankStatementDTO> sender;
    private final IBankStatementService bankStatementService;

    @Autowired
    public ExchangeBankStatement(ISender<BankStatementDTO> sender, IBankStatementService bankStatementService) {
        this.sender = sender;
        this.bankStatementService = bankStatementService;
    }

    @Override
    public void exchange(BankStatementDTO bankStatementDTO) {
        bankStatementService.deleteByExternalId(bankStatementDTO.getExternalId());
        HttpStatus status = sender.send(bankStatementDTO);
        if (status != HttpStatus.CREATED) {
            // Save database.
            bankStatementService.saveDTO(bankStatementDTO);
        }
    }
}
