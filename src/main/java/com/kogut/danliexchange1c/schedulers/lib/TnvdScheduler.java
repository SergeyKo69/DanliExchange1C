package com.kogut.danliexchange1c.schedulers.lib;

import com.kogut.danliexchange1c.dto.lib.tnvd.TnvdDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.tnvd.TnvdEntity;
import com.kogut.danliexchange1c.schedulers.AbstractLibScheduler;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class TnvdScheduler extends AbstractLibScheduler<TnvdDTO, TnvdEntity> {

    @Autowired
    public TnvdScheduler(IExchange<TnvdDTO> exchangeService,
                         IBaseLibService<TnvdEntity, TnvdDTO> dbService,
                         AbstractMapper<TnvdEntity, TnvdDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
