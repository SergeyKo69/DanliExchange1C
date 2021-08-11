package com.kogut.danliexchange1c.repositories.document;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.document.invoicereceived.InvoiceReceivedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 11.08.2021
 */

@Repository
public interface InvoiceReceivedRepository extends JpaRepository<InvoiceReceivedEntity, String> {

    List<InvoiceReceivedEntity> findAllByExternalId(String externalId);
    List<InvoiceReceivedEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<InvoiceReceivedEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
