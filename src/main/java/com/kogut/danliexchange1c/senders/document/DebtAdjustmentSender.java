package com.kogut.danliexchange1c.senders.document;

import com.kogut.danliexchange1c.dto.document.debtadjustment.DebtAdjustmentDTO;
import com.kogut.danliexchange1c.senders.AbstractSender;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author S.Kogut on 02.09.2021
 */

@Component
public class DebtAdjustmentSender extends AbstractSender<DebtAdjustmentDTO> implements ISender<DebtAdjustmentDTO> {

    @Autowired
    public DebtAdjustmentSender(ISettingsUtil settingsUtil, RestTemplate restTemplate) {
        super(settingsUtil, restTemplate);
    }

    @Override
    public HttpStatus send(DebtAdjustmentDTO debtAdjustmentDTO) {
        return super.send(debtAdjustmentDTO, "pathDebtAdjustment");
    }

}
