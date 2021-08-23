package com.kogut.danliexchange1c.schedulers.document;

import com.kogut.danliexchange1c.dto.document.bankstatement.BankStatementDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.bankstatement.BankStatementEntity;
import com.kogut.danliexchange1c.schedulers.AbstractDocScheduler;
import com.kogut.danliexchange1c.services.db.document.interfaces.IBaseDocService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class BankStatementScheduler extends AbstractDocScheduler<BankStatementDTO, BankStatementEntity> {

    @Autowired
    public BankStatementScheduler(IExchange<BankStatementDTO> exchangeService,
                                  IBaseDocService<BankStatementEntity, BankStatementDTO> dbService,
                                  AbstractMapper<BankStatementEntity, BankStatementDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
