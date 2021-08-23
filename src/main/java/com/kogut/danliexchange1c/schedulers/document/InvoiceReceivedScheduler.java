package com.kogut.danliexchange1c.schedulers.document;

import com.kogut.danliexchange1c.dto.document.invoicereceived.InvoiceReceivedDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.invoicereceived.InvoiceReceivedEntity;
import com.kogut.danliexchange1c.schedulers.AbstractDocScheduler;
import com.kogut.danliexchange1c.services.db.document.interfaces.IBaseDocService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class InvoiceReceivedScheduler extends AbstractDocScheduler<InvoiceReceivedDTO, InvoiceReceivedEntity> {

    @Autowired
    public InvoiceReceivedScheduler(IExchange<InvoiceReceivedDTO> exchangeService,
                                    IBaseDocService<InvoiceReceivedEntity, InvoiceReceivedDTO> dbService,
                                    AbstractMapper<InvoiceReceivedEntity, InvoiceReceivedDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
