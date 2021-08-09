package com.kogut.danliexchange1c.repositories.lib;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.common.GroupLibEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 09.08.2021
 */

@Repository
public interface GroupLibRepository extends JpaRepository<GroupLibEntity, String> {

    List<GroupLibEntity> findAllByExternalId(String externalId);
    List<GroupLibEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<GroupLibEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
