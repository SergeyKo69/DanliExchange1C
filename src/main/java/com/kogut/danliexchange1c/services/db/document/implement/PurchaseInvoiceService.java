package com.kogut.danliexchange1c.services.db.document.implement;

import com.kogut.danliexchange1c.dto.document.purchaseinvoice.PurchaseInvoiceDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.document.PurchaseInvoiceMapper;
import com.kogut.danliexchange1c.model.document.purchaseinvoice.PurchaseInvoiceEntity;
import com.kogut.danliexchange1c.repositories.document.PurchaseInvoiceRepository;
import com.kogut.danliexchange1c.services.db.document.interfaces.IPurchaseInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S.Kogut on 10.08.2021
 */

@Service
public class PurchaseInvoiceService implements IPurchaseInvoiceService {

    private final PurchaseInvoiceRepository purchaseInvoiceRepository;
    private final PurchaseInvoiceMapper purchaseInvoiceMapper;

    @Autowired
    public PurchaseInvoiceService(PurchaseInvoiceRepository purchaseInvoiceRepository,
                                  PurchaseInvoiceMapper purchaseInvoiceMapper) {
        this.purchaseInvoiceRepository = purchaseInvoiceRepository;
        this.purchaseInvoiceMapper = purchaseInvoiceMapper;
    }

    @Override
    @Transactional
    public PurchaseInvoiceEntity save(PurchaseInvoiceEntity entity) {
        return purchaseInvoiceRepository.save(entity);
    }

    @Override
    @Transactional
    public PurchaseInvoiceEntity saveDTO(PurchaseInvoiceDTO dto) {
        return purchaseInvoiceRepository.save(purchaseInvoiceMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<PurchaseInvoiceEntity> saveAll(List<PurchaseInvoiceEntity> entity) {
        return purchaseInvoiceRepository.saveAll(entity);
    }

    @Override
    @Transactional
    public List<PurchaseInvoiceEntity> findAll() {
        return purchaseInvoiceRepository.findAll();
    }

    @Override
    @Transactional
    public List<PurchaseInvoiceDTO> findAllDTO() {
        return purchaseInvoiceRepository.findAll()
                .stream().map(purchaseInvoiceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PurchaseInvoiceEntity> findAllByExternalId(String externalId) {
        return purchaseInvoiceRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<PurchaseInvoiceEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return purchaseInvoiceRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<PurchaseInvoiceDTO> findAllByClientDBOrderByDateTimeDTO(ClientDBEnum clientDB) {
        return purchaseInvoiceRepository.findAllByClientDBOrderByDateTime(clientDB)
                .parallelStream()
                .map(purchaseInvoiceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        purchaseInvoiceRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        purchaseInvoiceRepository.deleteAll();
    }
}
