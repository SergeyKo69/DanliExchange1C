package com.kogut.danliexchange1c.senders.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 24.07.2021
 */

@Component
public class InvoiceSender implements ISender<InvoiceDTO> {

    @Override
    public HttpStatus send(InvoiceDTO invoiceDTO) {
        return null;
    }
}
