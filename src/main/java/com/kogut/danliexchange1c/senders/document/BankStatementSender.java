package com.kogut.danliexchange1c.senders.document;

import com.kogut.danliexchange1c.dto.document.bankstatement.BankStatementDTO;
import com.kogut.danliexchange1c.senders.AbstractSender;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.util.interfaces.ISettingsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author S.Kogut on 12.08.2021
 */

@Component
public class BankStatementSender extends AbstractSender<BankStatementDTO> implements ISender<BankStatementDTO> {

    @Autowired
    public BankStatementSender(ISettingsUtil settingsUtil, RestTemplate restTemplate) {
        super(settingsUtil, restTemplate);
    }

    @Override
    public HttpStatus send(BankStatementDTO bankStatementDTO) {
        return super.send(bankStatementDTO, "pathBankStatement");
    }

}
