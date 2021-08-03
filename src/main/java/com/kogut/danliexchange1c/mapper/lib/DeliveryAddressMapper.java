package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.project.DeliveryAddressDTO;
import com.kogut.danliexchange1c.dto.lib.project.ProjectDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.deliveryaddress.DeliveryAddressEntity;
import com.kogut.danliexchange1c.model.lib.project.ProjectEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author S.Kogut on 03.08.2021
 */

@Component
public class DeliveryAddressMapper extends AbstractMapper<DeliveryAddressEntity, DeliveryAddressDTO> {

    private final ModelMapper mapper;

    public DeliveryAddressMapper(ModelMapper mapper) {
        super(DeliveryAddressEntity.class, DeliveryAddressDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(DeliveryAddressDTO.class, DeliveryAddressEntity.class)
                .addMappings(m -> m.skip(DeliveryAddressEntity:: setId))
                .addMappings(m -> m.skip(DeliveryAddressEntity::setClientDB));
    }

    @Override
    public void mapSpecificFields(DeliveryAddressEntity source, DeliveryAddressDTO destination) {
        super.mapSpecificFields(source, destination);
    }

    @Override
    public void mapSpecificFields(DeliveryAddressDTO source, DeliveryAddressEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
    }
}
