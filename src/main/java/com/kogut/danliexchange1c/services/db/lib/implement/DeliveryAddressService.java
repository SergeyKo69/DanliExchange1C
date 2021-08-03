package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.project.DeliveryAddressDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.DeliveryAddressMapper;
import com.kogut.danliexchange1c.model.lib.deliveryaddress.DeliveryAddressEntity;
import com.kogut.danliexchange1c.repositories.lib.DeliveryAddressRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IDeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 03.08.2021
 */

@Service
public class DeliveryAddressService implements IDeliveryAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;
    private final DeliveryAddressMapper mapper;

    @Autowired
    public DeliveryAddressService(DeliveryAddressRepository deliveryAddressRepository,
                                  DeliveryAddressMapper mapper) {
        this.deliveryAddressRepository = deliveryAddressRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public DeliveryAddressEntity save(DeliveryAddressEntity deliveryAddress) {
        return deliveryAddressRepository.save(deliveryAddress);
    }

    @Override
    @Transactional
    public void saveDTO(DeliveryAddressDTO deliveryAddress) {
        deliveryAddressRepository.save(mapper.toEntity(deliveryAddress));
    }

    @Override
    @Transactional
    public List<DeliveryAddressEntity> saveAll(List<DeliveryAddressEntity> addresses) {
        return deliveryAddressRepository.saveAll(addresses);
    }

    @Override
    public List<DeliveryAddressEntity> findAll() {
        return deliveryAddressRepository.findAll();
    }

    @Override
    public List<DeliveryAddressEntity> findAllByExternalId(String externalId) {
        return deliveryAddressRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<DeliveryAddressEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return deliveryAddressRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<DeliveryAddressEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return deliveryAddressRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        deliveryAddressRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        deliveryAddressRepository.deleteAll();
    }

}
