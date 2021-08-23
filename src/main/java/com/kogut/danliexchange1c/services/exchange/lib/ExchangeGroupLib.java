package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.common.GroupLibDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IGroupLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 09.08.2021
 */

@Component
public class ExchangeGroupLib implements IExchange<GroupLibDTO> {

    private final ISender<GroupLibDTO> sender;
    private final IGroupLibService groupService;
    Logger logger = LoggerFactory.getLogger(ExchangeGroupLib.class);

    @Autowired
    public ExchangeGroupLib(ISender<GroupLibDTO> sender, IGroupLibService groupService) {
        this.sender = sender;
        this.groupService = groupService;
    }

    @Override
    public void exchange(GroupLibDTO groupLibDTO) {
        groupService.deleteByExternalId(groupLibDTO.getExternalId());
        try {
            HttpStatus status = sender.send(groupLibDTO);
            if (status != HttpStatus.CREATED) {
                // Save database.
                groupService.saveDTO(groupLibDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            groupService.saveDTO(groupLibDTO);
        }
    }
}
