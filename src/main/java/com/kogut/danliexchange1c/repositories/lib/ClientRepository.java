package com.kogut.danliexchange1c.repositories.lib;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.client.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 09.08.2021
 */

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, String> {

    List<ClientEntity> findAllByExternalId(String externalId);
    List<ClientEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<ClientEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
