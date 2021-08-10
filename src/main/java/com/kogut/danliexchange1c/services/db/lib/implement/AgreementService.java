package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.agreement.AgreementDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.AgreementMapper;
import com.kogut.danliexchange1c.model.lib.agreement.AgreementEntity;
import com.kogut.danliexchange1c.repositories.lib.AgreementRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Service
public class AgreementService implements IAgreementService {

    private final AgreementRepository agreementRepository;
    private final AgreementMapper agreementMapper;

    @Autowired
    public AgreementService(AgreementRepository agreementRepository, AgreementMapper agreementMapper) {
        this.agreementRepository = agreementRepository;
        this.agreementMapper = agreementMapper;
    }

    @Override
    @Transactional
    public AgreementEntity save(AgreementEntity entity) {
        return agreementRepository.save(entity);
    }

    @Override
    @Transactional
    public void saveDTO(AgreementDTO dto) {
        agreementRepository.save(agreementMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<AgreementEntity> saveAll(List<AgreementEntity> entities) {
        return agreementRepository.saveAll(entities);
    }

    @Override
    public List<AgreementEntity> findAll() {
        return agreementRepository.findAll();
    }

    @Override
    public List<AgreementEntity> findAllByExternalId(String externalId) {
        return agreementRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<AgreementEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return agreementRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<AgreementEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return agreementRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        agreementRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        agreementRepository.deleteAll();
    }
}
