package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.gtd.GtdDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IGtdService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 11.08.2021
 */

@Component
public class ExchangeGtd implements IExchange<GtdDTO> {

    private final ISender<GtdDTO> sender;
    private final IGtdService gtdService;

    @Autowired
    public ExchangeGtd(ISender<GtdDTO> sender, IGtdService gtdService) {
        this.sender = sender;
        this.gtdService = gtdService;
    }

    @Override
    public void exchange(GtdDTO gtdDTO) {
        gtdService.deleteByExternalId(gtdDTO.getExternalId());
        HttpStatus status = sender.send(gtdDTO);
        if (status != HttpStatus.CREATED) {
            // Save database.
            gtdService.saveDTO(gtdDTO);
        }
    }

}
