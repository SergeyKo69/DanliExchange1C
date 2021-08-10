package com.kogut.danliexchange1c.repositories.document;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceEntity;
import com.kogut.danliexchange1c.model.document.purchaseinvoice.PurchaseInvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoiceEntity, String> {

    List<PurchaseInvoiceEntity> findAllByExternalId(String externalId);
    List<PurchaseInvoiceEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<PurchaseInvoiceEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
