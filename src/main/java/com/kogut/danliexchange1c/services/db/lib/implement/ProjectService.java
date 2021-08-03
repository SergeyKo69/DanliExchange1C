package com.kogut.danliexchange1c.services.db.lib.implement;

import com.kogut.danliexchange1c.dto.lib.project.ProjectDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.lib.ProjectMapper;
import com.kogut.danliexchange1c.model.lib.project.ProjectEntity;
import com.kogut.danliexchange1c.repositories.lib.ProjectRepository;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author S.Kogut on 03.08.2021
 */

@Service
public class ProjectService implements IProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectService(ProjectRepository projectRepository,
                          ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    @Transactional
    public ProjectEntity save(ProjectEntity project) {
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public ProjectDTO saveDTO(ProjectDTO project) {
        return projectMapper.toDto(projectRepository.save(projectMapper.toEntity(project)));
    }

    @Override
    @Transactional
    public List<ProjectEntity> saveAll(List<ProjectEntity> projects) {
        return projectRepository.saveAll(projects);
    }

    @Override
    public List<ProjectEntity> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<ProjectEntity> findAllByExternalId(String externalId) {
        return projectRepository.findAllByExternalId(externalId);
    }

    @Override
    public List<ProjectEntity> findAllByClientDBOrderByDateTime(ClientDBEnum clientDB) {
        return projectRepository.findAllByClientDBOrderByDateTime(clientDB);
    }

    @Override
    public List<ProjectEntity> findAllByClientDBOrderByDateTimeDesc(ClientDBEnum clientDB) {
        return projectRepository.findAllByClientDBOrderByDateTimeDesc(clientDB);
    }

    @Override
    @Transactional
    public void deleteByExternalId(String externalId) {
        projectRepository.deleteByExternalId(externalId);
    }

    @Override
    @Transactional
    public void deleteAll() {
        projectRepository.deleteAll();
    }

}
