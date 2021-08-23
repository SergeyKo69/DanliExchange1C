package com.kogut.danliexchange1c.schedulers.lib;

import com.kogut.danliexchange1c.dto.lib.price.PriceDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.price.PriceEntity;
import com.kogut.danliexchange1c.schedulers.AbstractLibScheduler;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class PriceScheduler extends AbstractLibScheduler<PriceDTO, PriceEntity> {

    @Autowired
    public PriceScheduler(IExchange<PriceDTO> exchangeService,
                          IBaseLibService<PriceEntity, PriceDTO> dbService,
                          AbstractMapper<PriceEntity, PriceDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
