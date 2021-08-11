package com.kogut.danliexchange1c.repositories.document;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.document.purchaseinvoice.PurchaseInvoiceEntity;
import com.kogut.danliexchange1c.model.document.receiptcashorder.ReceiptCashOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 11.08.2021
 */

@Repository
public interface ReceiptCashOrderRepository extends JpaRepository<ReceiptCashOrderEntity, String> {

    List<ReceiptCashOrderEntity> findAllByExternalId(String externalId);
    List<ReceiptCashOrderEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<ReceiptCashOrderEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
