package com.kogut.danliexchange1c.schedulers.document;

import com.kogut.danliexchange1c.dto.document.purchaseinvoice.PurchaseInvoiceDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.purchaseinvoice.PurchaseInvoiceEntity;
import com.kogut.danliexchange1c.schedulers.AbstractDocScheduler;
import com.kogut.danliexchange1c.services.db.document.interfaces.IBaseDocService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class PurchaseInvoiceScheduler extends AbstractDocScheduler<PurchaseInvoiceDTO, PurchaseInvoiceEntity> {

    @Autowired
    public PurchaseInvoiceScheduler(IExchange<PurchaseInvoiceDTO> exchangeService,
                                    IBaseDocService<PurchaseInvoiceEntity, PurchaseInvoiceDTO> dbService,
                                    AbstractMapper<PurchaseInvoiceEntity, PurchaseInvoiceDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
