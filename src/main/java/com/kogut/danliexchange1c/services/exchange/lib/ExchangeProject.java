package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.project.ProjectDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IProjectService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 03.08.2021
 */

@Component
public class ExchangeProject implements IExchange<ProjectDTO> {

    private final ISender<ProjectDTO> sender;
    private final IProjectService projectService;
    Logger logger = LoggerFactory.getLogger(ExchangeProject.class);

    @Autowired
    public ExchangeProject(ISender<ProjectDTO> sender, IProjectService projectService) {
        this.sender = sender;
        this.projectService = projectService;
    }

    @Override
    public void exchange(ProjectDTO projectDTO) {
        projectService.deleteByExternalId(projectDTO.getExternalId());
        try {
            HttpStatus status = sender.send(projectDTO);
            if (status != HttpStatus.CREATED) {
                // Save database.
                projectService.saveDTO(projectDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            projectService.saveDTO(projectDTO);
        }
    }
}
