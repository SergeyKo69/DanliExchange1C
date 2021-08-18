package com.kogut.danliexchange1c.model.document.invoicereceived;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * @author S.Kogut on 18.08.2021
 */

@Getter
@Setter
@Embeddable
public class InvoiceReceivedPrepaymentTabEntity {

    @Column(name = "product_id", length = 36)
    private String productId = "";

    @Column(name = "content")
    private String content = "";

    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "amount_vat")
    private BigDecimal amountVat = BigDecimal.ZERO;

    @Column(name = "rate_vat")
    private Integer rateVat = 20;

}
