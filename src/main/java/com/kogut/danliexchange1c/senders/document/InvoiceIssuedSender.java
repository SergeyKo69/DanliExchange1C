package com.kogut.danliexchange1c.senders.document;

import com.kogut.danliexchange1c.dto.document.invoiceissued.InvoiceIssuedDTO;
import com.kogut.danliexchange1c.senders.AbstractSender;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class InvoiceIssuedSender extends AbstractSender<InvoiceIssuedDTO> implements ISender<InvoiceIssuedDTO> {

    @Autowired
    public InvoiceIssuedSender(ISettingsUtil settingsUtil, RestTemplate restTemplate) {
        super(settingsUtil, restTemplate);
    }

    @Override
    public HttpStatus send(InvoiceIssuedDTO invoiceIssuedDTO) {
        return super.send(invoiceIssuedDTO, "pathInvoiceIssued");
    }

}
