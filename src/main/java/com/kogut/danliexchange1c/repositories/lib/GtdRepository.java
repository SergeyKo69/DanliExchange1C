package com.kogut.danliexchange1c.repositories.lib;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.gtd.GtdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 11.08.2021
 */

@Repository
public interface GtdRepository extends JpaRepository<GtdEntity, String> {

    List<GtdEntity> findAllByExternalId(String externalId);
    List<GtdEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<GtdEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
