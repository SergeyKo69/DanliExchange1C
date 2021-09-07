package com.kogut.danliexchange1c.senders.document;

import com.kogut.danliexchange1c.dto.document.invoicereceived.InvoiceReceivedDTO;
import com.kogut.danliexchange1c.senders.AbstractSender;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author S.Kogut on 11.08.2021
 */

@Component
public class InvoiceReceivedSender extends AbstractSender<InvoiceReceivedDTO> implements ISender<InvoiceReceivedDTO> {

    @Autowired
    public InvoiceReceivedSender(ISettingsUtil settingsUtil, RestTemplate restTemplate) {
        super(settingsUtil, restTemplate);
    }

    @Override
    public HttpStatus send(InvoiceReceivedDTO invoiceReceivedDTO) {
        return super.send(invoiceReceivedDTO, "pathInvoiceReceived");
    }

}
