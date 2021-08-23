package com.kogut.danliexchange1c.schedulers.lib;

import com.kogut.danliexchange1c.dto.lib.gtd.GtdDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.gtd.GtdEntity;
import com.kogut.danliexchange1c.schedulers.AbstractLibScheduler;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class GtdScheduler extends AbstractLibScheduler<GtdDTO, GtdEntity> {

    @Autowired
    public GtdScheduler(IExchange<GtdDTO> exchangeService,
                        IBaseLibService<GtdEntity, GtdDTO> dbService,
                        AbstractMapper<GtdEntity, GtdDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
