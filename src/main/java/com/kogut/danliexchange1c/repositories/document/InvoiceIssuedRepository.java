package com.kogut.danliexchange1c.repositories.document;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.document.invoiceissued.InvoiceIssuedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Repository
public interface InvoiceIssuedRepository extends JpaRepository<InvoiceIssuedEntity, String> {

    List<InvoiceIssuedEntity> findAllByExternalId(String externalId);
    List<InvoiceIssuedEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<InvoiceIssuedEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
