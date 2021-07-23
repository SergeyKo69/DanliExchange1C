package com.kogut.danliexchange1c.services.exchange.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 24.07.2021
 */

@Component
public class ExchangeInvoice implements IExchange<InvoiceDTO> {

    private final ISender<InvoiceDTO> sender;

    @Autowired
    public ExchangeInvoice(ISender<InvoiceDTO> sender) {
        this.sender = sender;
    }

    @Override
    public void exchange(InvoiceDTO invoiceDTO) {
        HttpStatus status = sender.send(invoiceDTO);
        if (status != HttpStatus.CREATED) {
            // Save database.

        }
    }
}
