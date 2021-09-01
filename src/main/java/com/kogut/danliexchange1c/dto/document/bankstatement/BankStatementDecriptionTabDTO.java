package com.kogut.danliexchange1c.dto.document.bankstatement;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author S.Kogut on 12.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BankStatementDecriptionTabDTO extends AbstractDTO {

    private String agreementId = "";
    private String articleId = "";
    private BigDecimal multiplicity = BigDecimal.ZERO;
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal multiplicityK = BigDecimal.ZERO;
    private BigDecimal amountVR = BigDecimal.ZERO;
    private Integer rateVat = 20;
    private BigDecimal amountVat = BigDecimal.ZERO;
    private String projectDecriptionId = "";
    private String docRView = "";
    private String docRId = "";
    private BankStatementBaseDocDTO docR = new BankStatementBaseDocDTO();
    private String customerAccountCode = "";
    private String customerAccountPrepaymentCode = "";
    private String subcontoIdKt1 = "";
    private String subcontoIdKt2 = "";
    private String subcontoIdKt3 = "";
}
