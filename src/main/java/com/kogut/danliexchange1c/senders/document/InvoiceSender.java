package com.kogut.danliexchange1c.senders.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.senders.AbstractSender;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author S.Kogut on 24.07.2021
 */

@Component
public class InvoiceSender extends AbstractSender<InvoiceDTO> implements ISender<InvoiceDTO> {

    @Autowired
    public InvoiceSender(ISettingsUtil settingsUtil, RestTemplate restTemplate) {
        super(settingsUtil, restTemplate);
    }

    @Override
    public HttpStatus send(InvoiceDTO invoiceDTO) {
        return super.send(invoiceDTO, "path");
    }

}
