package com.kogut.danliexchange1c.repositories.lib;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.agreement.AgreementEntity;
import com.kogut.danliexchange1c.model.lib.project.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Repository
public interface AgreementRepository extends JpaRepository<AgreementEntity, String> {

    List<AgreementEntity> findAllByExternalId(String externalId);
    List<AgreementEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<AgreementEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
