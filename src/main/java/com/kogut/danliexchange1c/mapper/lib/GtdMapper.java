package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.gtd.GtdDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.gtd.GtdEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class GtdMapper extends AbstractMapper<GtdEntity, GtdDTO> {
    private final ModelMapper mapper;

    @Autowired
    public GtdMapper(ModelMapper mapper) {
        super(GtdEntity.class, GtdDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(GtdDTO.class, GtdEntity.class)
                .addMappings(m -> m.skip(GtdEntity:: setId))
                .addMappings(m -> m.skip(GtdEntity::setClientDB))
                .setPostConverter(toEntityConverter());
        mapper.createTypeMap(GtdEntity.class, GtdDTO.class)
                .setPostConverter(toDtoConverter());
    }

    @Override
    public void mapSpecificFields(GtdEntity source, GtdDTO destination) {
        super.mapSpecificFields(source, destination);
    }

    @Override
    public void mapSpecificFields(GtdDTO source, GtdEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
    }

}
