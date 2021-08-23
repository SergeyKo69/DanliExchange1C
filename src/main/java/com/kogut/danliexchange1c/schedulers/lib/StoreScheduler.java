package com.kogut.danliexchange1c.schedulers.lib;

import com.kogut.danliexchange1c.dto.lib.store.StoreDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.store.StoreEntity;
import com.kogut.danliexchange1c.schedulers.AbstractLibScheduler;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class StoreScheduler extends AbstractLibScheduler<StoreDTO, StoreEntity> {

    @Autowired
    public StoreScheduler(IExchange<StoreDTO> exchangeService,
                          IBaseLibService<StoreEntity, StoreDTO> dbService,
                          AbstractMapper<StoreEntity, StoreDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
