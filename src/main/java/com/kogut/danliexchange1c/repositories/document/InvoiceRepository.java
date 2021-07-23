package com.kogut.danliexchange1c.repositories.document;

import com.kogut.danliexchange1c.model.document.invoice.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, String> {
}
