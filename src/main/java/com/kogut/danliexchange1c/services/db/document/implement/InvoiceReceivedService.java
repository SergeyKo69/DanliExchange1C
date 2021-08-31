package com.kogut.danliexchange1c.services.db.document.implement;

import com.kogut.danliexchange1c.dto.document.invoicereceived.InvoiceReceivedDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.document.InvoiceReceivedMapper;
import com.kogut.danliexchange1c.model.document.invoicereceived.InvoiceReceivedEntity;
import com.kogut.danliexchange1c.repositories.document.InvoiceReceivedRepository;
import com.kogut.danliexchange1c.services.db.document.interfaces.IInvoiceReceivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S.Kogut on 11.08.2021
 */

@Service
public class InvoiceReceivedService implements IInvoiceReceivedService {

    private final InvoiceReceivedRepository invoiceReceivedRepository;
    private final InvoiceReceivedMapper invoiceReceivedMapper;

    @Autowired
    public InvoiceReceivedService(InvoiceReceivedRepository invoiceReceivedRepository, InvoiceReceivedMapper invoiceReceivedMapper) {
        this.invoiceReceivedRepository = invoiceReceivedRepository;
        this.invoiceReceivedMapper = invoiceReceivedMapper;
    }

    @Override
    @Transactional
    public InvoiceReceivedEntity save(InvoiceReceivedEntity entity) {
        return invoiceReceivedRepository.save(entity);
    }

    @Override
    @Transactional
    public InvoiceReceivedEntity saveDTO(InvoiceReceivedDTO dto) {
        return invoiceReceivedRepository.save(invoiceReceivedMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<InvoiceReceivedEntity> saveAll(List<InvoiceReceivedEntity> entity) {
        return invoiceReceivedRepository.saveAll(entity);
    }

    @Override
    public List<InvoiceReceivedEntity> findAll() {
        return invoiceReceivedRepository.findAll();
    }

    @Override
    @Transactional
    public List<InvoiceReceivedDTO> findAllDTO() {
        return invoiceReceivedRepository.findAll()
                .stream().map(invoiceReceivedMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceReceivedEntity> findAllByExternalId(String externalId) {
        return invoiceReceivedRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<InvoiceReceivedEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return invoiceReceivedRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<InvoiceReceivedDTO> findAllByClientDBOrderByDateTimeDTO(ClientDBEnum clientDB) {
        return invoiceReceivedRepository
                .findAllByClientDBOrderByDateTime(clientDB)
                .parallelStream()
                .map(invoiceReceivedMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        invoiceReceivedRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        invoiceReceivedRepository.deleteAll();
    }

}
