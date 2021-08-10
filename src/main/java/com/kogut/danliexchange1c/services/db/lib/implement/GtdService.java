package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.gtd.GtdDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.GtdMapper;
import com.kogut.danliexchange1c.model.lib.gtd.GtdEntity;
import com.kogut.danliexchange1c.repositories.lib.GtdRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IGtdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 11.08.2021
 */

@Service
public class GtdService implements IGtdService {

    private final GtdRepository gtdRepository;
    private final GtdMapper gtdMapper;

    @Autowired
    public GtdService(GtdRepository gtdRepository, GtdMapper gtdMapper) {
        this.gtdRepository = gtdRepository;
        this.gtdMapper = gtdMapper;
    }

    @Override
    @Transactional
    public GtdEntity save(GtdEntity entity) {
        return gtdRepository.save(entity);
    }

    @Override
    @Transactional
    public void saveDTO(GtdDTO dto) {
        gtdRepository.save(gtdMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<GtdEntity> saveAll(List<GtdEntity> entities) {
        return gtdRepository.saveAll(entities);
    }

    @Override
    public List<GtdEntity> findAll() {
        return gtdRepository.findAll();
    }

    @Override
    public List<GtdEntity> findAllByExternalId(String externalId) {
        return gtdRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<GtdEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return gtdRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<GtdEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return gtdRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        gtdRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        gtdRepository.deleteAll();
    }

}
