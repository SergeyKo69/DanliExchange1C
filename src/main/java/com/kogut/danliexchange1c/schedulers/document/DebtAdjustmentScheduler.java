package com.kogut.danliexchange1c.schedulers.document;

import com.kogut.danliexchange1c.dto.document.debtadjustment.DebtAdjustmentDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.debtadjustment.DebtAdjustmentEntity;
import com.kogut.danliexchange1c.schedulers.AbstractDocScheduler;
import com.kogut.danliexchange1c.services.db.document.interfaces.IBaseDocService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 02.09.2021
 */

@Component
public class DebtAdjustmentScheduler extends AbstractDocScheduler<DebtAdjustmentDTO, DebtAdjustmentEntity> {

    @Autowired
    public DebtAdjustmentScheduler(IExchange<DebtAdjustmentDTO> exchangeService,
                                   IBaseDocService<DebtAdjustmentEntity, DebtAdjustmentDTO> dbService,
                                   AbstractMapper<DebtAdjustmentEntity, DebtAdjustmentDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
