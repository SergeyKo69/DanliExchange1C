package com.kogut.danliexchange1c.schedulers.lib;

import com.kogut.danliexchange1c.dto.lib.deliveryaddress.DeliveryAddressDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.deliveryaddress.DeliveryAddressEntity;
import com.kogut.danliexchange1c.schedulers.AbstractLibScheduler;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class DeliveryAddressScheduler extends AbstractLibScheduler<DeliveryAddressDTO, DeliveryAddressEntity> {

    @Autowired
    public DeliveryAddressScheduler(IExchange<DeliveryAddressDTO> exchangeService,
                                    IBaseLibService<DeliveryAddressEntity, DeliveryAddressDTO> dbService,
                                    AbstractMapper<DeliveryAddressEntity, DeliveryAddressDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }
}
