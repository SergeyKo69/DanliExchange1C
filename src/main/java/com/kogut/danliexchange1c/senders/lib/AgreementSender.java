package com.kogut.danliexchange1c.senders.lib;

import com.kogut.danliexchange1c.dto.lib.agreement.AgreementDTO;
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
 * @author S.Kogut on 10.08.2021
 */

@Component
public class AgreementSender implements ISender<AgreementDTO> {

    private final RestTemplate restTemplate;
    private final ISettingsUtil settingsUtil;

    @Autowired
    public AgreementSender(RestTemplate restTemplate, ISettingsUtil settingsUtil) {
        this.restTemplate = restTemplate;
        this.settingsUtil = settingsUtil;
    }

    @Override
    public HttpStatus send(AgreementDTO agreementDTO) {
        HashMap<String, String> settings = settingsUtil.getSettings(ClientDBEnum.valueOf(agreementDTO.getClientDB()));
        StringBuilder url = new StringBuilder();
        url.append(settings.get("address")).append("/").append(settings.get("pathAgreement"));
        HttpEntity<AgreementDTO> request = new HttpEntity<>(agreementDTO, settingsUtil.createHeaders(settings.get("userName"), settings.get("password")));
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