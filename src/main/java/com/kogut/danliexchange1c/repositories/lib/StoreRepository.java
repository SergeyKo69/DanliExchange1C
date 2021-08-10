package com.kogut.danliexchange1c.repositories.lib;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, String> {

    List<StoreEntity> findAllByExternalId(String externalId);
    List<StoreEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<StoreEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
