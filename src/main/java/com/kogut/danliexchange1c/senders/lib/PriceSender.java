package com.kogut.danliexchange1c.senders.lib;

import com.kogut.danliexchange1c.dto.lib.price.PriceDTO;
import com.kogut.danliexchange1c.senders.AbstractSender;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class PriceSender extends AbstractSender<PriceDTO> implements ISender<PriceDTO> {

    @Autowired
    public PriceSender(ISettingsUtil settingsUtil, RestTemplate restTemplate) {
        super(settingsUtil, restTemplate);
    }

    @Override
    public HttpStatus send(PriceDTO priceDTO) {
        return super.send(priceDTO, "pathPrice");
    }

}
