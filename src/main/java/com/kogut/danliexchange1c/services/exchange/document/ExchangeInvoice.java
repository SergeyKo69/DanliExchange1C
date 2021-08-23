package com.kogut.danliexchange1c.services.exchange.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.document.interfaces.IInvoiceService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 24.07.2021
 */

@Component
public class ExchangeInvoice implements IExchange<InvoiceDTO> {

    private final ISender<InvoiceDTO> sender;
    private final IInvoiceService invoiceService;
    Logger logger = LoggerFactory.getLogger(ExchangeInvoice.class);

    @Autowired
    public ExchangeInvoice(ISender<InvoiceDTO> sender,
                           IInvoiceService invoiceService) {
        this.sender = sender;
        this.invoiceService = invoiceService;
    }

    @Override
    public void exchange(InvoiceDTO invoiceDTO) {
        invoiceService.deleteByExternalId(invoiceDTO.getExternalId());
        try {
            HttpStatus status = sender.send(invoiceDTO);
            if (status != HttpStatus.CREATED) {
                // Save database.
                invoiceService.saveDTO(invoiceDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            invoiceService.saveDTO(invoiceDTO);
        }
    }
}
