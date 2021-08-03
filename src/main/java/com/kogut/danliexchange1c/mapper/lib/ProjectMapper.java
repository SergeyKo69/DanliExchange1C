package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.project.ProjectDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.project.ProjectEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author S.Kogut on 03.08.2021
 */

@Component
public class ProjectMapper extends AbstractMapper<ProjectEntity, ProjectDTO> {

    private final ModelMapper mapper;

    @Autowired
    public ProjectMapper(ModelMapper mapper) {
        super(ProjectEntity.class, ProjectDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(ProjectDTO.class, ProjectEntity.class)
                .addMappings(m -> m.skip(ProjectEntity:: setId))
                .addMappings(m -> m.skip(ProjectEntity::setClientDB));
    }

    @Override
    public void mapSpecificFields(ProjectEntity source, ProjectDTO destination) {
        super.mapSpecificFields(source, destination);
    }

    @Override
    public void mapSpecificFields(ProjectDTO source, ProjectEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
    }
}
