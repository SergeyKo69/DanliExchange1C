package com.kogut.danliexchange1c.repositories.lib;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    List<ProductEntity> findAllByExternalId(String externalId);
    List<ProductEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<ProductEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);

}
