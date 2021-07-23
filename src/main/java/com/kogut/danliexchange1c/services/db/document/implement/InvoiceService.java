package com.kogut.danliexchange1c.services.db.document.implement;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.document.InvoiceMapper;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceEntity;
import com.kogut.danliexchange1c.repositories.document.InvoiceRepository;
import com.kogut.danliexchange1c.services.db.document.interfaces.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author S.Kogut on 24.07.2021
 */

@Service
public class InvoiceService implements IInvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository,
                          InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    @Transactional
    public InvoiceEntity save(@NotNull InvoiceEntity invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceEntity saveDTO(@NotNull InvoiceDTO invoiceDTO) {
        return save(invoiceMapper.toEntity(invoiceDTO));
    }

    @Override
    @Transactional
    public List<InvoiceEntity> saveAll(@NotNull List<InvoiceEntity> invoices) {
        return invoiceRepository.saveAll(invoices);
    }

    @Override
    @Transactional
    public InvoiceEntity update(@NotNull InvoiceEntity invoice) {
        return save(invoice);
    }

    @Override
    public List<InvoiceEntity> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<InvoiceEntity> findAllByExternalId(@NotNull String externalId) {
        return invoiceRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<InvoiceEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return invoiceRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<InvoiceDTO> findAllByClientDBOrderByDateTimeDTO(@NotNull ClientDBEnum clientDB) {
        List<InvoiceEntity> invoicesEntity = invoiceRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
        return invoicesEntity
                .stream()
                .map(invoiceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteByExternalId(@NotNull String externalId) {
        invoiceRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        invoiceRepository.deleteAll();
    }
}
