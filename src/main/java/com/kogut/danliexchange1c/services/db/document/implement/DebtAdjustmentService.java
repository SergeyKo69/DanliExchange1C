package com.kogut.danliexchange1c.services.db.document.implement;

import com.kogut.danliexchange1c.dto.document.debtadjustment.DebtAdjustmentDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.document.DebtAdjustmentMapper;
import com.kogut.danliexchange1c.model.document.debtadjustment.DebtAdjustmentEntity;
import com.kogut.danliexchange1c.repositories.document.DebtAdjustmentRepository;
import com.kogut.danliexchange1c.services.db.document.interfaces.IDebtAdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S.Kogut on 02.09.2021
 */

@Service
public class DebtAdjustmentService implements IDebtAdjustmentService {

    private DebtAdjustmentRepository debtAdjustmentRepository;
    private DebtAdjustmentMapper debtAdjustmentMapper;

    @Autowired
    public DebtAdjustmentService(DebtAdjustmentRepository debtAdjustmentRepository,
                                 DebtAdjustmentMapper debtAdjustmentMapper) {
        this.debtAdjustmentRepository = debtAdjustmentRepository;
        this.debtAdjustmentMapper = debtAdjustmentMapper;
    }

    @Override
    @Transactional
    public DebtAdjustmentEntity save(DebtAdjustmentEntity entity) {
        return debtAdjustmentRepository.save(entity);
    }

    @Override
    @Transactional
    public DebtAdjustmentEntity saveDTO(DebtAdjustmentDTO dto) {
        return debtAdjustmentRepository.save(debtAdjustmentMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<DebtAdjustmentEntity> saveAll(List<DebtAdjustmentEntity> entity) {
        return debtAdjustmentRepository.saveAll(entity);
    }

    @Override
    public List<DebtAdjustmentEntity> findAll() {
        return debtAdjustmentRepository.findAll();
    }

    @Override
    @Transactional
    public List<DebtAdjustmentDTO> findAllDTO() {
        return debtAdjustmentRepository
                .findAll()
                .stream()
                .map(debtAdjustmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DebtAdjustmentEntity> findAllByExternalId(String externalId) {
        return debtAdjustmentRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<DebtAdjustmentEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return debtAdjustmentRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<DebtAdjustmentDTO> findAllByClientDBOrderByDateTimeDTO(ClientDBEnum clientDB) {
        return debtAdjustmentRepository.findAllByClientDBOrderByDateTime(clientDB)
                .stream()
                .map(debtAdjustmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        debtAdjustmentRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        debtAdjustmentRepository.deleteAll();
    }
}
