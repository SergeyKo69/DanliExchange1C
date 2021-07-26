package com.kogut.danliexchange1c.senders.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author S.Kogut on 24.07.2021
 */

@Component
public class InvoiceSender implements ISender<InvoiceDTO> {

    @Value("${address.ka1}")
    private String addressKa1;

    @Value("${path.ka1.invoice}")
    private String pathKa1;

    @Value("${username.ka1}")
    private String userNameKa1;

    @Value("${password.ka1}")
    private String passwordKa1;

    @Value("${address.ka2}")
    private String addressKa2;

    @Value("${username.ka2}")
    private String userNameKa2;

    @Value("${password.ka2}")
    private String passwordKa2;

    @Value("${path.ka2.invoice}")
    private String pathKa2;

    private final RestTemplate restTemplate;

    @Autowired
    public InvoiceSender(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public HttpStatus send(InvoiceDTO invoiceDTO) {
        HashMap<String, String> settings = getSettings(ClientDBEnum.valueOf(invoiceDTO.getClientDB()));
        StringBuilder url = new StringBuilder();
        url.append(settings.get("address")).append("/").append(settings.get("path"));
        HttpEntity<InvoiceDTO> request = new HttpEntity<>(invoiceDTO, createHeaders(settings.get("userName"), settings.get("password")));
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    url.toString(),
                    request,
                    String.class);
            return response.getStatusCode();
        } catch (IllegalArgumentException | RestClientException e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    private HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(StandardCharsets.US_ASCII) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
            set("Content-Type", MediaType.APPLICATION_JSON.toString());
        }};
    }

    private HashMap<String,String> getSettings(ClientDBEnum clientDB) {
        HashMap<String,String> settings = new HashMap<>();
        if (clientDB == ClientDBEnum.KA1) {
            settings.put("address", addressKa2);
            settings.put("path", pathKa2);
            settings.put("userName", userNameKa2);
            settings.put("password", passwordKa2);
        } else {
            settings.put("address", addressKa1);
            settings.put("path", pathKa1);
            settings.put("userName", userNameKa1);
            settings.put("password", passwordKa1);
        }
        return settings;
    }
}
