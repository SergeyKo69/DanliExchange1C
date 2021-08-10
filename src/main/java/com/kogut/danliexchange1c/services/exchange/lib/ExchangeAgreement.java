package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.agreement.AgreementDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IAgreementService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class ExchangeAgreement implements IExchange<AgreementDTO> {

    private final ISender<AgreementDTO> sender;
    private final IAgreementService agreementService;

    @Autowired
    public ExchangeAgreement(ISender<AgreementDTO> sender, IAgreementService agreementService) {
        this.sender = sender;
        this.agreementService = agreementService;
    }

    @Override
    public void exchange(AgreementDTO agreementDTO) {
        agreementService.deleteByExternalId(agreementDTO.getExternalId());
        HttpStatus status = sender.send(agreementDTO);
        if (status != HttpStatus.CREATED) {
            // Save database.
            agreementService.saveDTO(agreementDTO);
        }
    }
}
