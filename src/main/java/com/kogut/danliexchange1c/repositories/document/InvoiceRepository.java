package com.kogut.danliexchange1c.repositories.document;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, String> {

    List<InvoiceEntity> findAllByExternalId(String externalId);
    List<InvoiceEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<InvoiceEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
