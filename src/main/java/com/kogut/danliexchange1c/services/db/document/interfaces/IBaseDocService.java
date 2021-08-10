package com.kogut.danliexchange1c.services.db.document.interfaces;

import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;

import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */
public interface IBaseDocService<E,D> {

    E save(E entity);
    E saveDTO(D dto);
    List<E> saveAll(List<E> entity);

    List<E> findAll();

    List<E> findAllByExternalId(String externalId);
    List<E> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<D> findAllByClientDBOrderByDateTimeDTO(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);
    void deleteAll();

}
