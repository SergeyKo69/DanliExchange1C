package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.store.StoreDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.store.StoreEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class StoreMapper extends AbstractMapper<StoreEntity, StoreDTO> {

    private final ModelMapper mapper;

    @Autowired
    public StoreMapper(ModelMapper mapper) {
        super(StoreEntity.class, StoreDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(StoreDTO.class, StoreEntity.class)
                .addMappings(m -> m.skip(StoreEntity:: setId))
                .addMappings(m -> m.skip(StoreEntity::setClientDB));
    }

    @Override
    public void mapSpecificFields(StoreEntity source, StoreDTO destination) {
        super.mapSpecificFields(source, destination);
    }

    @Override
    public void mapSpecificFields(StoreDTO source, StoreEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
    }

}
