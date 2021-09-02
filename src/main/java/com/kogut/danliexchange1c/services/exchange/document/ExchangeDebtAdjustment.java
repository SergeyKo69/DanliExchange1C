package com.kogut.danliexchange1c.services.exchange.document;

import com.kogut.danliexchange1c.dto.document.debtadjustment.DebtAdjustmentDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.document.interfaces.IDebtAdjustmentService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 02.09.2021
 */

@Component
public class ExchangeDebtAdjustment implements IExchange<DebtAdjustmentDTO> {

    private final ISender<DebtAdjustmentDTO> sender;
    private final IDebtAdjustmentService debtAdjustmentService;
    Logger logger = LoggerFactory.getLogger(ExchangeDebtAdjustment.class);

    @Autowired
    public ExchangeDebtAdjustment(ISender<DebtAdjustmentDTO> sender,
                                  IDebtAdjustmentService debtAdjustmentService) {
        this.sender = sender;
        this.debtAdjustmentService = debtAdjustmentService;
    }

    @Override
    public void exchange(DebtAdjustmentDTO debtAdjustmentDTO) {
        debtAdjustmentService.deleteByExternalId(debtAdjustmentDTO.getExternalId());
        try {
            HttpStatus status = sender.send(debtAdjustmentDTO);
            if (status != HttpStatus.CREATED) {
                // Save database.
                debtAdjustmentService.saveDTO(debtAdjustmentDTO);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            debtAdjustmentService.saveDTO(debtAdjustmentDTO);
        }
    }

}
