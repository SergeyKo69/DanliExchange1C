package com.kogut.danliexchange1c.schedulers.lib;

import com.kogut.danliexchange1c.dto.lib.client.ClientDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.client.ClientEntity;
import com.kogut.danliexchange1c.schedulers.AbstractLibScheduler;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class ClientScheduler extends AbstractLibScheduler<ClientDTO, ClientEntity> {

    @Autowired
    public ClientScheduler(IExchange<ClientDTO> exchangeService,
                           IBaseLibService<ClientEntity, ClientDTO> dbService,
                           AbstractMapper<ClientEntity, ClientDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
