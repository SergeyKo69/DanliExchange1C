package com.kogut.danliexchange1c.schedulers.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceEntity;
import com.kogut.danliexchange1c.schedulers.AbstractDocScheduler;
import com.kogut.danliexchange1c.services.db.document.interfaces.IBaseDocService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class InvoiceScheduler extends AbstractDocScheduler<InvoiceDTO, InvoiceEntity> {

    @Autowired
    public InvoiceScheduler(IExchange<InvoiceDTO> exchangeService,
                            IBaseDocService<InvoiceEntity, InvoiceDTO> dbService,
                            AbstractMapper<InvoiceEntity, InvoiceDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
