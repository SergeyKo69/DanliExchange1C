package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.common.GroupLibDTO;
import com.kogut.danliexchange1c.dto.lib.project.ProjectDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 09.08.2021
 */

@Component
public class ExgangeGroupLib implements IExchange<GroupLibDTO> {

    @Override
    public void exchange(GroupLibDTO groupLibDTO) {

    }
}
