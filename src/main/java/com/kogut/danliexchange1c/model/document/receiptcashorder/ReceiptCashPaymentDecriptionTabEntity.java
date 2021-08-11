package com.kogut.danliexchange1c.model.document.receiptcashorder;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.math.BigDecimal;

/**
 * @author S.Kogut on 11.08.2021
 */

@Getter
@Setter
@Embeddable
public class ReceiptCashPaymentDecriptionTabEntity {

    @Column(name = "agreement_id", length = 36)
    private String agreementId = "";

    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "multiplicity")
    private BigDecimal multiplicity = BigDecimal.ZERO;

    @Column(name = "amount_vr")
    private BigDecimal amountVR = BigDecimal.ZERO;

    @Column(name = "rate_vat")
    private Integer rateVat = 20;

    @Column(name = "amount_vat")
    private BigDecimal amountVat = BigDecimal.ZERO;

    @Column(name = "article_id", length = 36)
    private String articleId = "";

    @Column(name = "project_decription_id", length = 36)
    private String projectDecriptionId = "";

    @Column(name = "doc_r_view")
    private String docRView = "";

    @Column(name = "doc_r_id", length = 36)
    private String docRId = "";

    @Embedded
    @Column(name = "doc_r")
    private ReceiptCashBaseDocEntity docR;

}
