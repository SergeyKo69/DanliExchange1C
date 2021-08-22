package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.common.GroupLibDTO;
import com.kogut.danliexchange1c.dto.lib.project.ProjectDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.enumerations.lib.TypeOwnerGroupLibEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.common.GroupLibEntity;
import com.kogut.danliexchange1c.model.lib.project.ProjectEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author S.Kogut on 09.08.2021
 */

@Component
public class GroupLibMapper extends AbstractMapper<GroupLibEntity, GroupLibDTO>  {

    private final ModelMapper mapper;

    @Autowired
    public GroupLibMapper(ModelMapper mapper) {
        super(GroupLibEntity.class, GroupLibDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(GroupLibDTO.class, GroupLibEntity.class)
                .addMappings(m -> m.skip(GroupLibEntity:: setId))
                .addMappings(m -> m.skip(GroupLibEntity::setClientDB))
                .setPostConverter(toEntityConverter());
        mapper.createTypeMap(GroupLibEntity.class, GroupLibDTO.class)
                .setPostConverter(toDtoConverter());
    }

    @Override
    public void mapSpecificFields(GroupLibEntity source, GroupLibDTO destination) {
        super.mapSpecificFields(source, destination);
        destination.setTypeOwnerGroup(source.getTypeOwnerGroup().toString());
    }

    @Override
    public void mapSpecificFields(GroupLibDTO source, GroupLibEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
        destination.setTypeOwnerGroup(TypeOwnerGroupLibEnum.valueOf(source.getTypeOwnerGroup()));
    }
}
