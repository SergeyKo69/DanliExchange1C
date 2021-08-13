package com.kogut.danliexchange1c.senders.document;

import com.kogut.danliexchange1c.dto.document.invoicereceived.InvoiceReceivedDTO;
import com.kogut.danliexchange1c.dto.document.purchaseinvoice.PurchaseInvoiceDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.senders.lib.GtdSender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author S.Kogut on 11.08.2021
 */

@Component
public class InvoiceReceivedSender implements ISender<InvoiceReceivedDTO> {

    private final RestTemplate restTemplate;
    private final ISettingsUtil settingsUtil;

    Logger logger = LoggerFactory.getLogger(GtdSender.class);

    @Autowired
    public InvoiceReceivedSender(RestTemplate restTemplate, ISettingsUtil settingsUtil) {
        this.restTemplate = restTemplate;
        this.settingsUtil = settingsUtil;
    }

    @Override
    public HttpStatus send(InvoiceReceivedDTO invoiceReceivedDTO) {
        HashMap<String, String> settings = settingsUtil.getSettings(ClientDBEnum.valueOf(invoiceReceivedDTO.getClientDB()));
        StringBuilder url = new StringBuilder();
        url.append(settings.get("address")).append("/").append(settings.get("pathInvoiceReceived"));
        HttpEntity<InvoiceReceivedDTO> request = new HttpEntity<>(invoiceReceivedDTO, settingsUtil.createHeaders(settings.get("userName"), settings.get("password")));
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    url.toString(),
                    request,
                    String.class);
            return response.getStatusCode();
        } catch (IllegalArgumentException | RestClientException e) {
            logger.error(e.getMessage());
            return HttpStatus.BAD_REQUEST;
        }
    }
}
