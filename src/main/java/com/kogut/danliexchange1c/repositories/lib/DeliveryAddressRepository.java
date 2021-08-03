package com.kogut.danliexchange1c.repositories.lib;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.deliveryaddress.DeliveryAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 03.08.2021
 */

@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddressEntity, String> {

    List<DeliveryAddressEntity> findAllByExternalId(String externalId);
    List<DeliveryAddressEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<DeliveryAddressEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
