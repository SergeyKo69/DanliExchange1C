package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.store.StoreDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.StoreMapper;
import com.kogut.danliexchange1c.model.lib.store.StoreEntity;
import com.kogut.danliexchange1c.repositories.lib.StoreRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Service
public class StoreService implements IStoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    @Autowired
    public StoreService(StoreRepository storeRepository, StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    @Override
    @Transactional
    public StoreEntity save(StoreEntity entity) {
        return storeRepository.save(entity);
    }

    @Override
    @Transactional
    public void saveDTO(StoreDTO dto) {
        storeRepository.save(storeMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<StoreEntity> saveAll(List<StoreEntity> entities) {
        return storeRepository.saveAll(entities);
    }

    @Override
    public List<StoreEntity> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public List<StoreEntity> findAllByExternalId(String externalId) {
        return storeRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<StoreEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return storeRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<StoreEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return storeRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        storeRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        storeRepository.deleteAll();
    }

}
