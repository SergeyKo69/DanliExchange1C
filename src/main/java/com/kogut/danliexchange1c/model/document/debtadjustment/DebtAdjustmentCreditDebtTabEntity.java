package com.kogut.danliexchange1c.model.document.debtadjustment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * @author S.Kogut on 02.09.2021
 */

@Getter
@Setter
@Embeddable
public class DebtAdjustmentCreditDebtTabEntity {

    @Column(name = "agreement_id", length = 36)
    private String agreementId = "";

    @Column(name = "course")
    private BigDecimal course = BigDecimal.ONE;

    @Column(name = "multiplicity")
    private Integer multiplicity = 1;

    @Column(name = "doc_id", length = 36)
    private String docId = "";

    @Column(name = "doc_view")
    private String docView = "";

    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "amount_nu")
    private BigDecimal amountNU = BigDecimal.ZERO;

    @Column(name = "amount_vr")
    private BigDecimal amountVR = BigDecimal.ZERO;

    @Column(name = "bill_code")
    private String billCode = "";

}
