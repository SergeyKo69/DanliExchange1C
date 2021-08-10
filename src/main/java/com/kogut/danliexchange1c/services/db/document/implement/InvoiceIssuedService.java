package com.kogut.danliexchange1c.services.db.document.implement;

import com.kogut.danliexchange1c.dto.document.invoiceissued.InvoiceIssuedDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.document.InvoiceIssuedMapper;
import com.kogut.danliexchange1c.model.document.invoiceissued.InvoiceIssuedEntity;
import com.kogut.danliexchange1c.repositories.document.InvoiceIssuedRepository;
import com.kogut.danliexchange1c.services.db.document.interfaces.IInvoiceIssuedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S.Kogut on 10.08.2021
 */

@Service
public class InvoiceIssuedService implements IInvoiceIssuedService {

    private final InvoiceIssuedRepository invoiceIssuedRepository;
    private final InvoiceIssuedMapper invoiceIssuedMapper;

    @Autowired
    public InvoiceIssuedService(InvoiceIssuedRepository invoiceIssuedRepository, InvoiceIssuedMapper invoiceIssuedMapper) {
        this.invoiceIssuedRepository = invoiceIssuedRepository;
        this.invoiceIssuedMapper = invoiceIssuedMapper;
    }

    @Override
    @Transactional
    public InvoiceIssuedEntity save(InvoiceIssuedEntity entity) {
        return invoiceIssuedRepository.save(entity);
    }

    @Override
    @Transactional
    public InvoiceIssuedEntity saveDTO(InvoiceIssuedDTO dto) {
        return invoiceIssuedRepository.save(invoiceIssuedMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public List<InvoiceIssuedEntity> saveAll(List<InvoiceIssuedEntity> entity) {
        return invoiceIssuedRepository.saveAll(entity);
    }

    @Override
    public List<InvoiceIssuedEntity> findAll() {
        return invoiceIssuedRepository.findAll();
    }

    @Override
    public List<InvoiceIssuedEntity> findAllByExternalId(String externalId) {
        return invoiceIssuedRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<InvoiceIssuedEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return invoiceIssuedRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<InvoiceIssuedDTO> findAllByClientDBOrderByDateTimeDTO(ClientDBEnum clientDB) {
        return invoiceIssuedRepository.findAllByClientDBOrderByDateTime(clientDB)
                .parallelStream()
                .map(invoiceIssuedMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        invoiceIssuedRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        invoiceIssuedRepository.deleteAll();
    }
}
