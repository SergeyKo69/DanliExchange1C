package com.kogut.danliexchange1c.schedulers.lib;

import com.kogut.danliexchange1c.dto.lib.project.ProjectDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.project.ProjectEntity;
import com.kogut.danliexchange1c.schedulers.AbstractLibScheduler;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class ProjectScheduler extends AbstractLibScheduler<ProjectDTO, ProjectEntity> {

    @Autowired
    public ProjectScheduler(IExchange<ProjectDTO> exchangeService,
                            IBaseLibService<ProjectEntity, ProjectDTO> dbService,
                            AbstractMapper<ProjectEntity, ProjectDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
