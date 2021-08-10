package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.tnvd.TnvdDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.ITnvdService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 11.08.2021
 */

@Component
public class ExchangeTnvd implements IExchange<TnvdDTO> {

    private final ISender<TnvdDTO> sender;
    private final ITnvdService tnvdService;

    @Autowired
    public ExchangeTnvd(ISender<TnvdDTO> sender, ITnvdService tnvdService) {
        this.sender = sender;
        this.tnvdService = tnvdService;
    }

    @Override
    public void exchange(TnvdDTO tnvdDTO) {
        tnvdService.deleteByExternalId(tnvdDTO.getExternalId());
        HttpStatus status = sender.send(tnvdDTO);
        if (status != HttpStatus.CREATED) {
            // Save database.
            tnvdService.saveDTO(tnvdDTO);
        }
    }

}
