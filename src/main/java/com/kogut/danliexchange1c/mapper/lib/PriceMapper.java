package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.price.PriceDTO;
import com.kogut.danliexchange1c.dto.lib.project.ProjectDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.price.PriceEntity;
import com.kogut.danliexchange1c.model.lib.project.ProjectEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class PriceMapper extends AbstractMapper<PriceEntity, PriceDTO> {

    private final ModelMapper mapper;

    @Autowired
    public PriceMapper(ModelMapper mapper) {
        super(PriceEntity.class, PriceDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(PriceDTO.class, PriceEntity.class)
                .addMappings(m -> m.skip(PriceEntity:: setId))
                .addMappings(m -> m.skip(PriceEntity::setClientDB));
    }

    @Override
    public void mapSpecificFields(PriceEntity source, PriceDTO destination) {
        super.mapSpecificFields(source, destination);
    }

    @Override
    public void mapSpecificFields(PriceDTO source, PriceEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
    }

}
