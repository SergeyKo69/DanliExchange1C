package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.tnvd.TnvdDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.tnvd.TnvdEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author S.Kogut on 11.08.2021
 */

@Component
public class TnvdMapper extends AbstractMapper<TnvdEntity, TnvdDTO> {

    private final ModelMapper mapper;

    @Autowired
    public TnvdMapper(ModelMapper mapper) {
        super(TnvdEntity.class, TnvdDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(TnvdDTO.class, TnvdEntity.class)
                .addMappings(m -> m.skip(TnvdEntity:: setId))
                .addMappings(m -> m.skip(TnvdEntity::setClientDB))
                .setPostConverter(toEntityConverter());
        mapper.createTypeMap(TnvdEntity.class, TnvdDTO.class)
                .setPostConverter(toDtoConverter());
    }

    @Override
    public void mapSpecificFields(TnvdEntity source, TnvdDTO destination) {
        super.mapSpecificFields(source, destination);
    }

    @Override
    public void mapSpecificFields(TnvdDTO source, TnvdEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
    }

}
