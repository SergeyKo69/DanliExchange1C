package com.kogut.danliexchange1c.schedulers.lib;

import com.kogut.danliexchange1c.dto.lib.bankbill.BankBillDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.bankbill.BankBillEntity;
import com.kogut.danliexchange1c.schedulers.AbstractLibScheduler;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class BankBillScheduler extends AbstractLibScheduler<BankBillDTO, BankBillEntity> {

    @Autowired
    public BankBillScheduler(IExchange<BankBillDTO> exchangeService,
                             IBaseLibService<BankBillEntity, BankBillDTO> dbService,
                             AbstractMapper<BankBillEntity, BankBillDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }
}
