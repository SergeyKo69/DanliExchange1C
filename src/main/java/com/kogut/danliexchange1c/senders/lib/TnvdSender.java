package com.kogut.danliexchange1c.senders.lib;

import com.kogut.danliexchange1c.dto.lib.tnvd.TnvdDTO;
import com.kogut.danliexchange1c.senders.AbstractSender;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author S.Kogut on 11.08.2021
 */

@Component
public class TnvdSender extends AbstractSender<TnvdDTO> implements ISender<TnvdDTO> {

    @Autowired
    public TnvdSender(ISettingsUtil settingsUtil, RestTemplate restTemplate) {
        super(settingsUtil, restTemplate);
    }

    @Override
    public HttpStatus send(TnvdDTO tnvdDTO) {
        return super.send(tnvdDTO, "pathTnvd");
    }

}
