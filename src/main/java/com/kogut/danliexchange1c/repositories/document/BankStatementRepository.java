package com.kogut.danliexchange1c.repositories.document;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.document.bankstatement.BankStatementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 12.08.2021
 */

@Repository
public interface BankStatementRepository extends JpaRepository<BankStatementEntity, String> {

    List<BankStatementEntity> findAllByExternalId(String externalId);
    List<BankStatementEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<BankStatementEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);


}
