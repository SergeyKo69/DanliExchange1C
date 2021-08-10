package com.kogut.danliexchange1c.repositories.lib;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.price.PriceEntity;
import com.kogut.danliexchange1c.model.lib.project.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, String> {

    List<ProjectEntity> findAllByExternalId(String externalId);
    List<ProjectEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<ProjectEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
