package com.kogut.danliexchange1c.services.db.document.interfaces;

import com.kogut.danliexchange1c.model.document.invoice.InvoiceEntity;

import java.util.List;

/**
 * @author S.Kogut on 24.07.2021
 */
public interface IInvoiceService {

    InvoiceEntity save(InvoiceEntity invoice);
    List<InvoiceEntity> saveAll(List<InvoiceEntity> invoices);

}
