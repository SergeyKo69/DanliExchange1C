package com.kogut.danliexchange1c.services.db.document.interfaces;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceEntity;

import java.util.List;

/**
 * @author S.Kogut on 24.07.2021
 */
public interface IInvoiceService {

    InvoiceEntity save(InvoiceEntity invoice);
    InvoiceEntity saveDTO(InvoiceDTO invoiceDTO);
    List<InvoiceEntity> saveAll(List<InvoiceEntity> invoices);
    InvoiceEntity update(InvoiceEntity invoice);

    List<InvoiceEntity> findAll();

    List<InvoiceEntity> findAllByExternalId(String externalId);
    List<InvoiceEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<InvoiceDTO> findAllByClientDBOrderByDateTimeDTO(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);
    void deleteAll();

}
