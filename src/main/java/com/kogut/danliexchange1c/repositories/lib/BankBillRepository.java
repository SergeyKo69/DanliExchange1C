package com.kogut.danliexchange1c.repositories.lib;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.bankbill.BankBillEntity;
import com.kogut.danliexchange1c.model.lib.client.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 09.08.2021
 */

@Repository
public interface BankBillRepository extends JpaRepository<BankBillEntity, String> {

    List<BankBillEntity> findAllByExternalId(String externalId);
    List<BankBillEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<BankBillEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
