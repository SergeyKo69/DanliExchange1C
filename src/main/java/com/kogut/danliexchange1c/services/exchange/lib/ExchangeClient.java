package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.client.ClientDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IClientService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 09.08.2021
 */

@Component
public class ExchangeClient implements IExchange<ClientDTO> {

    private final ISender<ClientDTO> sender;
    private final IClientService clientService;

    @Autowired
    public ExchangeClient(ISender<ClientDTO> sender, IClientService clientService) {
        this.sender = sender;
        this.clientService = clientService;
    }

    @Override
    public void exchange(ClientDTO clientDTO) {
        clientService.deleteByExternalId(clientDTO.getExternalId());
        HttpStatus status = sender.send(clientDTO);
        if (status != HttpStatus.CREATED) {
            // Save database.
            clientService.saveDTO(clientDTO);
        }
    }
}
