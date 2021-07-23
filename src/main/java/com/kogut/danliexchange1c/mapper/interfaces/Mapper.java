package com.kogut.danliexchange1c.mapper.interfaces;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import com.kogut.danliexchange1c.model.common.AbstractEntity;

/**
 * @author S.Kogut on 11.06.2021
 */
public interface Mapper<E extends AbstractEntity, D extends AbstractDTO> {

    E toEntity(D dto);

    D toDto(E entity);

    void updateEntityOfDTO(D dto, E entity);

}
