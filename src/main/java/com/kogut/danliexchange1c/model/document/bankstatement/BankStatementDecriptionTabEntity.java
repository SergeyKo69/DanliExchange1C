package com.kogut.danliexchange1c.model.document.bankstatement;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.math.BigDecimal;

/**
 * @author S.Kogut on 12.08.2021
 */

@Getter
@Setter
@Embeddable
public class BankStatementDecriptionTabEntity {

    @Column(name = "agreement_id", length = 36)
    private String agreementId = "";

    @Column(name = "article_id", length = 36)
    private String articleId = "";

    @Column(name = "multiplicity")
    private BigDecimal multiplicity = BigDecimal.ZERO;

    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "multiplicity_k")
    private BigDecimal multiplicityK = BigDecimal.ZERO;

    @Column(name = "amount_vr")
    private BigDecimal amountVR = BigDecimal.ZERO;

    @Column(name = "rate_vat")
    private Integer rateVat = 20;

    @Column(name = "amount_vat")
    private BigDecimal amountVat = BigDecimal.ZERO;

    @Column(name = "project_decription_id")
    private String projectDecriptionId = "";

    @Column(name = "doc_r_view")
    private String docRView = "";

    @Column(name = "doc_r_id")
    private String docRId = "";

    @Embedded
    @Column(name = "doc_r")
    private BankStatementBaseDocEntity docR;

    @Column(name = "customer_account_code")
    private String customerAccountCode = "";

    @Column(name = "customer_account_prepayment_code")
    private String customerAccountPrepaymentCode = "";

    @Column(name = "subconto_id_kt_1")
    private String subcontoIdKt1 = "";

    @Column(name = "subconto_id_kt_2")
    private String subcontoIdKt2 = "";

    @Column(name = "subconto_id_kt_3")
    private String subcontoIdKt3 = "";

}
