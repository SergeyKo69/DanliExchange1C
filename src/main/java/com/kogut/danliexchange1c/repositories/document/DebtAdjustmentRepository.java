package com.kogut.danliexchange1c.repositories.document;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.document.debtadjustment.DebtAdjustmentEntity;
import com.kogut.danliexchange1c.model.document.invoiceissued.InvoiceIssuedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 02.09.2021
 */

@Repository
public interface DebtAdjustmentRepository extends JpaRepository<DebtAdjustmentEntity, String> {

    List<DebtAdjustmentEntity> findAllByExternalId(String externalId);
    List<DebtAdjustmentEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<DebtAdjustmentEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
