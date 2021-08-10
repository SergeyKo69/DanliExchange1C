package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.store.StoreDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IStoreService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class ExchangeStore implements IExchange<StoreDTO> {

    private final ISender<StoreDTO> sender;
    private final IStoreService storeService;

    @Autowired
    public ExchangeStore(ISender<StoreDTO> sender, IStoreService storeService) {
        this.sender = sender;
        this.storeService = storeService;
    }

    @Override
    public void exchange(StoreDTO storeDTO) {
        storeService.deleteByExternalId(storeDTO.getExternalId());
        HttpStatus status = sender.send(storeDTO);
        if (status != HttpStatus.CREATED) {
            // Save database.
            storeService.saveDTO(storeDTO);
        }
    }
}
