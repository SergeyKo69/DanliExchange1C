package com.kogut.danliexchange1c.senders.lib;

import com.kogut.danliexchange1c.dto.lib.project.ProjectDTO;
import com.kogut.danliexchange1c.senders.AbstractSender;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author S.Kogut on 03.08.2021
 */

@Component
public class ProjectSender extends AbstractSender<ProjectDTO> implements ISender<ProjectDTO> {

    @Autowired
    public ProjectSender(ISettingsUtil settingsUtil, RestTemplate restTemplate) {
        super(settingsUtil, restTemplate);
    }

    @Override
    public HttpStatus send(ProjectDTO projectDTO) {
        return super.send(projectDTO, "pathProject");
    }

}
