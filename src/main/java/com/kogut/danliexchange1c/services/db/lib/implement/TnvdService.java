package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.tnvd.TnvdDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.TnvdMapper;
import com.kogut.danliexchange1c.model.lib.tnvd.TnvdEntity;
import com.kogut.danliexchange1c.repositories.lib.TnvdRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.ITnvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 11.08.2021
 */

@Service
public class TnvdService implements ITnvdService {

    private final TnvdRepository tnvdRepository;
    private final TnvdMapper tnvdMapper;

    @Autowired
    public TnvdService(TnvdRepository tnvdRepository, TnvdMapper tnvdMapper) {
        this.tnvdRepository = tnvdRepository;
        this.tnvdMapper = tnvdMapper;
    }

    @Override
    @Transactional
    public TnvdEntity save(TnvdEntity entity) {
        return tnvdRepository.save(entity);
    }

    @Override
    @Transactional
    public void saveDTO(TnvdDTO dto) {
        tnvdRepository.save(tnvdMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<TnvdEntity> saveAll(List<TnvdEntity> entities) {
        return tnvdRepository.saveAll(entities);
    }

    @Override
    public List<TnvdEntity> findAll() {
        return tnvdRepository.findAll();
    }

    @Override
    public List<TnvdEntity> findAllByExternalId(String externalId) {
        return tnvdRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<TnvdEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return tnvdRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<TnvdEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return tnvdRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    public void deleteByExternalId(String externalId) {
        tnvdRepository.deleteByExternalId(externalId);
    }

    @Override
    public void deleteAll() {
        tnvdRepository.deleteAll();
    }
}
