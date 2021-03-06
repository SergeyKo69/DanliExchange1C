package com.kogut.danliexchange1c.services.exchange.document;

import com.kogut.danliexchange1c.dto.document.receiptcashorder.ReceiptCashOrderDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.document.interfaces.IReceiptCashOrderService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 11.08.2021
 */

@Component
public class ExchangeReceiptCashOrder implements IExchange<ReceiptCashOrderDTO> {

    private final ISender<ReceiptCashOrderDTO> sender;
    private final IReceiptCashOrderService receiptCashOrderService;
    Logger logger = LoggerFactory.getLogger(ExchangeReceiptCashOrder.class);

    @Autowired
    public ExchangeReceiptCashOrder(ISender<ReceiptCashOrderDTO> sender,
                                    IReceiptCashOrderService receiptCashOrderService) {
        this.sender = sender;
        this.receiptCashOrderService = receiptCashOrderService;
    }

    @Override
    public void exchange(ReceiptCashOrderDTO receiptCashOrderDTO) {
        receiptCashOrderService.deleteByExternalId(receiptCashOrderDTO.getExternalId());
        try {
            HttpStatus status = sender.send(receiptCashOrderDTO);
            if (status != HttpStatus.CREATED) {
                // Save database.
                receiptCashOrderService.saveDTO(receiptCashOrderDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            receiptCashOrderService.saveDTO(receiptCashOrderDTO);
        }
    }

}
