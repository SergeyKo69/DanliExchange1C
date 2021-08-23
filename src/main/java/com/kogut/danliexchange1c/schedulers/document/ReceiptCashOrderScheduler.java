package com.kogut.danliexchange1c.schedulers.document;

import com.kogut.danliexchange1c.dto.document.receiptcashorder.ReceiptCashOrderDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.receiptcashorder.ReceiptCashOrderEntity;
import com.kogut.danliexchange1c.schedulers.AbstractDocScheduler;
import com.kogut.danliexchange1c.services.db.document.interfaces.IBaseDocService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class ReceiptCashOrderScheduler extends AbstractDocScheduler<ReceiptCashOrderDTO, ReceiptCashOrderEntity> {

    @Autowired
    public ReceiptCashOrderScheduler(IExchange<ReceiptCashOrderDTO> exchangeService,
                                     IBaseDocService<ReceiptCashOrderEntity, ReceiptCashOrderDTO> dbService,
                                     AbstractMapper<ReceiptCashOrderEntity, ReceiptCashOrderDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
