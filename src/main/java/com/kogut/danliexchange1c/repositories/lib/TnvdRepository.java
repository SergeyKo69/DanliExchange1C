package com.kogut.danliexchange1c.repositories.lib;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.tnvd.TnvdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 11.08.2021
 */

@Repository
public interface TnvdRepository extends JpaRepository<TnvdEntity, String> {

    List<TnvdEntity> findAllByExternalId(String externalId);
    List<TnvdEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<TnvdEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
