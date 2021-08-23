package com.kogut.danliexchange1c.senders.lib;

import com.kogut.danliexchange1c.dto.lib.client.ClientDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
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
 * @author S.Kogut on 09.08.2021
 */

@Component
public class ClientSender  implements ISender<ClientDTO> {

    private final RestTemplate restTemplate;
    private final ISettingsUtil settingsUtil;

    Logger logger = LoggerFactory.getLogger(ClientSender.class);

    @Autowired
    public ClientSender(RestTemplate restTemplate, ISettingsUtil settingsUtil) {
        this.restTemplate = restTemplate;
        this.settingsUtil = settingsUtil;
    }

    @Override
    public HttpStatus send(ClientDTO clientDTO) {
        HashMap<String, String> settings = settingsUtil.getSettings(ClientDBEnum.valueOf(clientDTO.getClientDB()));
        StringBuilder url = new StringBuilder();
        url.append(settings.get("address")).append("/").append(settings.get("pathClient"));
        HttpEntity<ClientDTO> request = new HttpEntity<>(clientDTO, settingsUtil.createHeaders(settings.get("userName"), settings.get("password")));
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
