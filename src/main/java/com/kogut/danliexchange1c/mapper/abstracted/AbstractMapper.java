package com.kogut.danliexchange1c.mapper.abstracted;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import com.kogut.danliexchange1c.mapper.interfaces.Mapper;
import com.kogut.danliexchange1c.model.common.AbstractEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @author S.Kogut on 11.06.2021
 */

public abstract class AbstractMapper<E extends AbstractEntity, D extends AbstractDTO> implements Mapper<E, D> {

    @Autowired
    private ModelMapper mapper;

    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    public AbstractMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, entityClass);
    }

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, dtoClass);
    }

    @Override
    public void updateEntityOfDTO(D dto, E entity) {
        if (!Objects.isNull(entity) && !Objects.isNull(dto)) {
            mapper.map(dto, entity);
        }
    }

    public Converter<E, D> toDtoConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    public Converter<D, E> toEntityConverter() {
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    public void mapSpecificFields(E source, D destination) {
    }

    public void mapSpecificFields(D source, E destination) {
    }

}
