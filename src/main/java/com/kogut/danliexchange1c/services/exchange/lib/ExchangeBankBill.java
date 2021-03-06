package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.bankbill.BankBillDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBankBillService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 09.08.2021
 */

@Component
public class ExchangeBankBill implements IExchange<BankBillDTO> {

    private final ISender<BankBillDTO> sender;
    private final IBankBillService bankBillService;
    Logger logger = LoggerFactory.getLogger(ExchangeBankBill.class);

    @Autowired
    public ExchangeBankBill(ISender<BankBillDTO> sender, IBankBillService bankBillService) {
        this.sender = sender;
        this.bankBillService = bankBillService;
    }

    @Override
    public void exchange(BankBillDTO bankBillDTO) {
        bankBillService.deleteByExternalId(bankBillDTO.getExternalId());
        try {
            HttpStatus status = sender.send(bankBillDTO);
            if (status != HttpStatus.CREATED) {
                // Save database.
                bankBillService.saveDTO(bankBillDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            bankBillService.saveDTO(bankBillDTO);
        }

    }
}
