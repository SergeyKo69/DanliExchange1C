package com.kogut.danliexchange1c.senders;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author S.Kogut on 07.09.2021
 */
public abstract class AbstractSender<D extends AbstractDTO> {

    private final ISettingsUtil settingsUtil;
    private final RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public AbstractSender(ISettingsUtil settingsUtil,
                          RestTemplate restTemplate) {
        this.settingsUtil = settingsUtil;
        this.restTemplate = restTemplate;
    }

    public HttpStatus send(D d, String pathName) {
        HashMap<String, String> settings = settingsUtil.getSettings(ClientDBEnum.valueOf(d.getClientDB()));
        StringBuilder url = new StringBuilder();
        url.append(settings.get("address")).append("/").append(settings.get(pathName));
        HttpEntity<D> request = new HttpEntity<>(d, settingsUtil.createHeaders(settings.get("userName"), settings.get("password")));
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    url.toString(),
                    request,
                    String.class);
            String body = response.getBody();
            if (Objects.nonNull(body) && !body.isEmpty()) {
                logger.info(body);
            }
            return response.getStatusCode();
        } catch (IllegalArgumentException | RestClientException e) {
            logger.error(e.getMessage());
            return HttpStatus.BAD_REQUEST;
        }
    }
}
