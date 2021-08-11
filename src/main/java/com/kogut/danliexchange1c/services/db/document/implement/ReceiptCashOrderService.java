package com.kogut.danliexchange1c.services.db.document.implement;

import com.kogut.danliexchange1c.dto.document.receiptcashorder.ReceiptCashOrderDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.document.ReceiptCashOrderMapper;
import com.kogut.danliexchange1c.model.document.receiptcashorder.ReceiptCashOrderEntity;
import com.kogut.danliexchange1c.repositories.document.ReceiptCashOrderRepository;
import com.kogut.danliexchange1c.services.db.document.interfaces.IReceiptCashOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S.Kogut on 11.08.2021
 */

@Service
public class ReceiptCashOrderService implements IReceiptCashOrderService {

    private final ReceiptCashOrderRepository receiptCashOrderRepository;
    private final ReceiptCashOrderMapper receiptCashOrderMapper;

    @Autowired
    public ReceiptCashOrderService(ReceiptCashOrderRepository receiptCashOrderRepository,
                                   ReceiptCashOrderMapper receiptCashOrderMapper) {
        this.receiptCashOrderRepository = receiptCashOrderRepository;
        this.receiptCashOrderMapper = receiptCashOrderMapper;
    }

    @Override
    @Transactional
    public ReceiptCashOrderEntity save(ReceiptCashOrderEntity entity) {
        return receiptCashOrderRepository.save(entity);
    }

    @Override
    @Transactional
    public ReceiptCashOrderEntity saveDTO(ReceiptCashOrderDTO dto) {
        return receiptCashOrderRepository.save(receiptCashOrderMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<ReceiptCashOrderEntity> saveAll(List<ReceiptCashOrderEntity> entity) {
        return receiptCashOrderRepository.saveAll(entity);
    }

    @Override
    public List<ReceiptCashOrderEntity> findAll() {
        return receiptCashOrderRepository.findAll();
    }

    @Override
    public List<ReceiptCashOrderEntity> findAllByExternalId(String externalId) {
        return receiptCashOrderRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<ReceiptCashOrderEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return receiptCashOrderRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<ReceiptCashOrderDTO> findAllByClientDBOrderByDateTimeDTO(ClientDBEnum clientDB) {
        return receiptCashOrderRepository.findAllByClientDBOrderByDateTime(clientDB)
                .parallelStream()
                .map(receiptCashOrderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        receiptCashOrderRepository.deleteByExternalId(externalId);
    }

    @Override
    public void deleteAll() {
        receiptCashOrderRepository.deleteAll();
    }
}
