package com.kogut.danliexchange1c.dto.document.debtadjustment;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author S.Kogut on 02.09.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DebtAdjustmentCreditDebtTabDTO extends AbstractDTO {

    private String agreementId = "";
    private BigDecimal course = BigDecimal.ONE;
    private Integer multiplicity = 1;
    private String docId = "";
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal amountNU = BigDecimal.ZERO;
    private BigDecimal amountVR = BigDecimal.ZERO;
    private String billCode = "";

}
