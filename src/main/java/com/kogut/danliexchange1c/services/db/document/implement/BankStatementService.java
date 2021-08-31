package com.kogut.danliexchange1c.services.db.document.implement;

import com.kogut.danliexchange1c.dto.document.bankstatement.BankStatementDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.document.BankStatementMapper;
import com.kogut.danliexchange1c.model.document.bankstatement.BankStatementEntity;
import com.kogut.danliexchange1c.repositories.document.BankStatementRepository;
import com.kogut.danliexchange1c.services.db.document.interfaces.IBankStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S.Kogut on 12.08.2021
 */

@Service
public class BankStatementService implements IBankStatementService {

    private final BankStatementRepository bankStatementRepository;
    private final BankStatementMapper bankStatementMapper;

    @Autowired
    public BankStatementService(BankStatementRepository bankStatementRepository,
                                BankStatementMapper bankStatementMapper) {
        this.bankStatementRepository = bankStatementRepository;
        this.bankStatementMapper = bankStatementMapper;
    }

    @Override
    @Transactional
    public BankStatementEntity save(BankStatementEntity entity) {
        return bankStatementRepository.save(entity);
    }

    @Override
    @Transactional
    public BankStatementEntity saveDTO(BankStatementDTO dto) {
        return bankStatementRepository.save(bankStatementMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<BankStatementEntity> saveAll(List<BankStatementEntity> entity) {
        return bankStatementRepository.saveAll(entity);
    }

    @Override
    public List<BankStatementEntity> findAll() {
        return bankStatementRepository.findAll();
    }

    @Override
    @Transactional
    public List<BankStatementDTO> findAllDTO() {
        return bankStatementRepository.findAll()
                .stream().map(bankStatementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BankStatementEntity> findAllByExternalId(String externalId) {
        return bankStatementRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<BankStatementEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return bankStatementRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<BankStatementDTO> findAllByClientDBOrderByDateTimeDTO(ClientDBEnum clientDB) {
        return bankStatementRepository.findAllByClientDBOrderByDateTime(clientDB)
                .parallelStream()
                .map(bankStatementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        bankStatementRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        bankStatementRepository.deleteAll();
    }
}
