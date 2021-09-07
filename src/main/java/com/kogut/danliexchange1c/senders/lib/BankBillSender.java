package com.kogut.danliexchange1c.senders.lib;

import com.kogut.danliexchange1c.dto.lib.bankbill.BankBillDTO;
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
public class BankBillSender extends AbstractSender<BankBillDTO> implements ISender<BankBillDTO> {

    @Autowired
    public BankBillSender(ISettingsUtil settingsUtil, RestTemplate restTemplate) {
        super(settingsUtil, restTemplate);
    }

    @Override
    public HttpStatus send(BankBillDTO bankBillDTO) {
        return super.send(bankBillDTO, "pathBankBill");
    }

}
