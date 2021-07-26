package com.kogut.danliexchange1c.senders.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author S.Kogut on 24.07.2021
 */

@Component
public class InvoiceSender implements ISender<InvoiceDTO> {

    @Value("address.ka1")
    private String addressKa1;

    @Value("path.ka1.invoice")
    private String pathKa1;

    @Value("username.ka1")
    private String userNameKa1;

    @Value("password.ka1")
    private String passwordKa1;

    @Value("address.ka2")
    private String addressKa2;

    @Value("username.ka2")
    private String userNameKa2;

    @Value("password.ka2")
    private String passwordKa2;

    @Value("path.ka2.invoice")
    private String pathKa2;

    private final RestTemplate restTemplate;

    @Autowired
    public InvoiceSender(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public HttpStatus send(InvoiceDTO invoiceDTO) {
        HashMap<String, String> settings = getSettings(ClientDBEnum.valueOf(invoiceDTO.getClientDB()));
        StringBuilder path = new StringBuilder();
        HttpEntity<InvoiceDTO> request = new HttpEntity<>(invoiceDTO, getHeaders(settings));
        ResponseEntity<String> response = restTemplate.postForEntity(
                path.append(settings.get("address")).append("/").append(settings.get("path")).toString(),
                request,
                String.class);
        return response.getStatusCode();
    }

    private HttpHeaders getHeaders(HashMap<String, String> settings) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBasicAuth(settings.get("userName"), settings.get("password"));
        return httpHeaders;
    }

    private HashMap<String,String> getSettings(ClientDBEnum clientDB) {
        HashMap<String,String> settings = new HashMap<>();
        if (clientDB == ClientDBEnum.KA1) {
            settings.put("address", addressKa1);
            settings.put("path", pathKa1);
            settings.put("userName", userNameKa1);
            settings.put("password", passwordKa1);
        } else {
            settings.put("address", addressKa2);
            settings.put("path", pathKa2);
            settings.put("userName", userNameKa2);
            settings.put("password", passwordKa2);
        }
        return settings;
    }
}
