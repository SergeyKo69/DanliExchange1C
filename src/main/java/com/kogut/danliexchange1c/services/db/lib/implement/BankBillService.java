package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.bankbill.BankBillDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.BankBillMapper;
import com.kogut.danliexchange1c.model.lib.bankbill.BankBillEntity;
import com.kogut.danliexchange1c.repositories.lib.BankBillRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBankBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 09.08.2021
 */

@Service
public class BankBillService implements IBankBillService {

    private final BankBillRepository bankBillRepository;
    private final BankBillMapper bankBillMapper;

    @Autowired
    public BankBillService(BankBillRepository bankBillRepository, BankBillMapper bankBillMapper) {
        this.bankBillRepository = bankBillRepository;
        this.bankBillMapper = bankBillMapper;
    }

    @Override
    @Transactional
    public BankBillEntity save(BankBillEntity entity) {
        return bankBillRepository.save(entity);
    }

    @Override
    @Transactional
    public void saveDTO(BankBillDTO dto) {
        bankBillRepository.save(bankBillMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<BankBillEntity> saveAll(List<BankBillEntity> entities) {
        return bankBillRepository.saveAll(entities);
    }

    @Override
    public List<BankBillEntity> findAll() {
        return bankBillRepository.findAll();
    }

    @Override
    public List<BankBillEntity> findAllByExternalId(String externalId) {
        return bankBillRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<BankBillEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return bankBillRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<BankBillEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return bankBillRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        bankBillRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        bankBillRepository.deleteAll();
    }
}
