package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.deliveryaddress.DeliveryAddressDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IDeliveryAddressService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 03.08.2021
 */

@Component
public class ExchangeDeliveryAddress implements IExchange<DeliveryAddressDTO> {

    private final ISender<DeliveryAddressDTO> sender;
    private final IDeliveryAddressService deliveryAddressService;
    Logger logger = LoggerFactory.getLogger(ExchangeDeliveryAddress.class);

    @Autowired
    public ExchangeDeliveryAddress(ISender<DeliveryAddressDTO> sender, IDeliveryAddressService deliveryAddressService) {
        this.sender = sender;
        this.deliveryAddressService = deliveryAddressService;
    }

    @Override
    public void exchange(DeliveryAddressDTO deliveryAddressDTO) {
        deliveryAddressService.deleteByExternalId(deliveryAddressDTO.getExternalId());
        try {
            HttpStatus status = sender.send(deliveryAddressDTO);
            if (status != HttpStatus.CREATED) {
                // Save database.
                deliveryAddressService.saveDTO(deliveryAddressDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            deliveryAddressService.saveDTO(deliveryAddressDTO);
        }
    }
}
