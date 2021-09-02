package com.kogut.danliexchange1c.senders.document;

import com.kogut.danliexchange1c.dto.document.bankstatement.BankStatementDTO;
import com.kogut.danliexchange1c.dto.document.debtadjustment.DebtAdjustmentDTO;
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
import java.util.Objects;

/**
 * @author S.Kogut on 02.09.2021
 */

@Component
public class DebtAdjustmentSender implements ISender<DebtAdjustmentDTO> {

    private final RestTemplate restTemplate;
    private final ISettingsUtil settingsUtil;

    Logger logger = LoggerFactory.getLogger(DebtAdjustmentSender.class);

    @Autowired
    public DebtAdjustmentSender(RestTemplate restTemplate, ISettingsUtil settingsUtil) {
        this.restTemplate = restTemplate;
        this.settingsUtil = settingsUtil;
    }

    @Override
    public HttpStatus send(DebtAdjustmentDTO debtAdjustmentDTO) {
        HashMap<String, String> settings = settingsUtil.getSettings(ClientDBEnum.valueOf(debtAdjustmentDTO.getClientDB()));
        StringBuilder url = new StringBuilder();
        url.append(settings.get("address")).append("/").append(settings.get("pathDebtAdjustment"));
        HttpEntity<DebtAdjustmentDTO> request = new HttpEntity<>(debtAdjustmentDTO, settingsUtil.createHeaders(settings.get("userName"), settings.get("password")));
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
