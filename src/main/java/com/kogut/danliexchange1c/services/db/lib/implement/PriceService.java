package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.price.PriceDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.PriceMapper;
import com.kogut.danliexchange1c.model.lib.price.PriceEntity;
import com.kogut.danliexchange1c.repositories.lib.PriceRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Service
public class PriceService implements IPriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    @Autowired
    public PriceService(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    @Transactional
    public PriceEntity save(PriceEntity entity) {
        return priceRepository.save(entity);
    }

    @Override
    @Transactional
    public void saveDTO(PriceDTO dto) {
        priceRepository.save(priceMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<PriceEntity> saveAll(List<PriceEntity> entities) {
        return priceRepository.saveAll(entities);
    }

    @Override
    public List<PriceEntity> findAll() {
        return priceRepository.findAll();
    }

    @Override
    public List<PriceEntity> findAllByExternalId(String externalId) {
        return priceRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<PriceEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return priceRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<PriceEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return priceRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        priceRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        priceRepository.deleteAll();
    }
}
