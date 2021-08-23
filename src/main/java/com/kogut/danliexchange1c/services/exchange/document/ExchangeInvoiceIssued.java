package com.kogut.danliexchange1c.services.exchange.document;

import com.kogut.danliexchange1c.dto.document.invoiceissued.InvoiceIssuedDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.document.interfaces.IInvoiceIssuedService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class ExchangeInvoiceIssued implements IExchange<InvoiceIssuedDTO> {

    private final ISender<InvoiceIssuedDTO> sender;
    private final IInvoiceIssuedService invoiceIssuedService;
    Logger logger = LoggerFactory.getLogger(ExchangeInvoiceIssued.class);

    @Autowired
    public ExchangeInvoiceIssued(ISender<InvoiceIssuedDTO> sender, IInvoiceIssuedService invoiceIssuedService) {
        this.sender = sender;
        this.invoiceIssuedService = invoiceIssuedService;
    }

    @Override
    public void exchange(InvoiceIssuedDTO invoiceIssuedDTO) {
        invoiceIssuedService.deleteByExternalId(invoiceIssuedDTO.getExternalId());
        try {
            HttpStatus status = sender.send(invoiceIssuedDTO);
            if (status != HttpStatus.CREATED) {
                // Save database.
                invoiceIssuedService.saveDTO(invoiceIssuedDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            invoiceIssuedService.saveDTO(invoiceIssuedDTO);
        }
    }
}
