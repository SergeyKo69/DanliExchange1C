package com.kogut.danliexchange1c.senders.lib;

import com.kogut.danliexchange1c.dto.lib.gtd.GtdDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
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
public class GtdSender implements ISender<GtdDTO> {

    private final RestTemplate restTemplate;
    private final ISettingsUtil settingsUtil;

    @Autowired
    public GtdSender(RestTemplate restTemplate, ISettingsUtil settingsUtil) {
        this.restTemplate = restTemplate;
        this.settingsUtil = settingsUtil;
    }

    @Override
    public HttpStatus send(GtdDTO gtdDTO) {
        HashMap<String, String> settings = settingsUtil.getSettings(ClientDBEnum.valueOf(gtdDTO.getClientDB()));
        StringBuilder url = new StringBuilder();
        url.append(settings.get("address")).append("/").append(settings.get("pathGtd"));
        HttpEntity<GtdDTO> request = new HttpEntity<>(gtdDTO, settingsUtil.createHeaders(settings.get("userName"), settings.get("password")));
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
}
