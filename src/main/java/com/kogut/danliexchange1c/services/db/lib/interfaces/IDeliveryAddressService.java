package com.kogut.danliexchange1c.services.db.lib.interfaces;

import com.kogut.danliexchange1c.dto.lib.project.DeliveryAddressDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.deliveryaddress.DeliveryAddressEntity;

import java.util.List;

/**
 * @author S.Kogut on 03.08.2021
 */
public interface IDeliveryAddressService {

    DeliveryAddressEntity save(DeliveryAddressEntity deliveryAddress);
    void saveDTO(DeliveryAddressDTO deliveryAddress);
    List<DeliveryAddressEntity> saveAll(List<DeliveryAddressEntity> addresses);

    List<DeliveryAddressEntity> findAll();

    List<DeliveryAddressEntity> findAllByExternalId(String externalId);
    List<DeliveryAddressEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<DeliveryAddressEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);
    void deleteAll();

}
