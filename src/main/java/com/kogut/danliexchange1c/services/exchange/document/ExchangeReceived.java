package com.kogut.danliexchange1c.services.exchange.document;

import com.kogut.danliexchange1c.dto.document.invoicereceived.InvoiceReceivedDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.document.interfaces.IInvoiceReceivedService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 11.08.2021
 */

@Component
public class ExchangeReceived implements IExchange<InvoiceReceivedDTO> {

    private final ISender<InvoiceReceivedDTO> sender;
    private final IInvoiceReceivedService invoiceReceivedService;

    @Autowired
    public ExchangeReceived(ISender<InvoiceReceivedDTO> sender, IInvoiceReceivedService invoiceReceivedService) {
        this.sender = sender;
        this.invoiceReceivedService = invoiceReceivedService;
    }

    @Override
    public void exchange(InvoiceReceivedDTO invoiceReceivedDTO) {
        invoiceReceivedService.deleteByExternalId(invoiceReceivedDTO.getExternalId());
        HttpStatus status = sender.send(invoiceReceivedDTO);
        if (status != HttpStatus.CREATED) {
            // Save database.
            invoiceReceivedService.saveDTO(invoiceReceivedDTO);
        }
    }
}
