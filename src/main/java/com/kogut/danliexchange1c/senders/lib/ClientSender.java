package com.kogut.danliexchange1c.senders.lib;

import com.kogut.danliexchange1c.dto.lib.client.ClientDTO;
import com.kogut.danliexchange1c.senders.AbstractSender;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author S.Kogut on 09.08.2021
 */

@Component
public class ClientSender extends AbstractSender<ClientDTO> implements ISender<ClientDTO> {

    @Autowired
    public ClientSender(ISettingsUtil settingsUtil, RestTemplate restTemplate) {
        super(settingsUtil, restTemplate);
    }

    @Override
    public HttpStatus send(ClientDTO clientDTO) {
        return super.send(clientDTO, "pathClient");
    }

}
