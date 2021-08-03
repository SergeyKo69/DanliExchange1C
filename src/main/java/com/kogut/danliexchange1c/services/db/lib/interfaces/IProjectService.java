package com.kogut.danliexchange1c.services.db.lib.interfaces;

import com.kogut.danliexchange1c.dto.lib.project.ProjectDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.model.lib.project.ProjectEntity;

import java.util.List;

/**
 * @author S.Kogut on 03.08.2021
 */
public interface IProjectService {

    ProjectEntity save(ProjectEntity project);
    void saveDTO(ProjectDTO project);
    List<ProjectEntity> saveAll(List<ProjectEntity> projects);

    List<ProjectEntity> findAll();

    List<ProjectEntity> findAllByExternalId(String externalId);
    List<ProjectEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB);
    List<ProjectEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB);

    void deleteByExternalId(String externalId);
    void deleteAll();

}
