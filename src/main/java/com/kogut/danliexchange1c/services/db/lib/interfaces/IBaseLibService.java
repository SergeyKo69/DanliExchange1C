package com.kogut.danliexchange1c.services.db.lib.interfaces;

import com.kogut.danliexchange1c.dto.lib.deliveryaddress.DeliveryAddressDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.deliveryaddress.DeliveryAddressEntity;

import java.util.List;

/**
 * @author S.Kogut on 09.08.2021
 */
public interface IBaseLibService<E,D> {

    E save(E entity);
    void saveDTO(D dto);
    List<E> saveAll(List<E> entities);

    List<E> findAll();

    List<E> findAllByExternalId(String externalId);
    List<E> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<E> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);
    void deleteAll();

}
