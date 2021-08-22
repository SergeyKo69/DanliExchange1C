package com.kogut.danliexchange1c.schedulers.lib;

import com.kogut.danliexchange1c.dto.lib.agreement.AgreementDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.agreement.AgreementEntity;
import com.kogut.danliexchange1c.schedulers.AbstractLibScheduler;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class AgreementScheduler extends AbstractLibScheduler<AgreementDTO, AgreementEntity> {

    @Autowired
    public AgreementScheduler(IExchange<AgreementDTO> exchangeService,
                              IBaseLibService<AgreementEntity, AgreementDTO> dbService,
                              AbstractMapper<AgreementEntity, AgreementDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
