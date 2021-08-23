package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.price.PriceDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IPriceService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class ExchangePrice implements IExchange<PriceDTO> {

    private final ISender<PriceDTO> sender;
    private final IPriceService priceService;
    Logger logger = LoggerFactory.getLogger(ExchangePrice.class);

    @Autowired
    public ExchangePrice(ISender<PriceDTO> sender, IPriceService priceService) {
        this.sender = sender;
        this.priceService = priceService;
    }

    @Override
    public void exchange(PriceDTO priceDTO) {
        priceService.deleteByExternalId(priceDTO.getExternalId());
        try {
            HttpStatus status = sender.send(priceDTO);
            if (status != HttpStatus.CREATED) {
                // Save database.
                priceService.saveDTO(priceDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            priceService.saveDTO(priceDTO);
        }
    }
}
