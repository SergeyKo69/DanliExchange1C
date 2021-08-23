package com.kogut.danliexchange1c.schedulers.document;

import com.kogut.danliexchange1c.dto.document.invoiceissued.InvoiceIssuedDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.invoiceissued.InvoiceIssuedEntity;
import com.kogut.danliexchange1c.schedulers.AbstractDocScheduler;
import com.kogut.danliexchange1c.services.db.document.interfaces.IBaseDocService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class InvoiceIssuedScheduler extends AbstractDocScheduler<InvoiceIssuedDTO, InvoiceIssuedEntity> {

    @Autowired
    public InvoiceIssuedScheduler(IExchange<InvoiceIssuedDTO> exchangeService,
                                  IBaseDocService<InvoiceIssuedEntity, InvoiceIssuedDTO> dbService,
                                  AbstractMapper<InvoiceIssuedEntity, InvoiceIssuedDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
