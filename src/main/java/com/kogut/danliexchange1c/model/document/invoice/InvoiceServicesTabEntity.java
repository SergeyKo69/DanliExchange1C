package com.kogut.danliexchange1c.model.document.invoice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * @author S.Kogut on 22.07.2021
 */

@Getter
@Setter
@Embeddable
public class InvoiceServicesTabEntity {

    @Column(name = "productId")
    private String productId = "";

    @Column(name = "quantity")
    private BigDecimal quantity = BigDecimal.ZERO;

    @Column(name = "price")
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "amountVAT")
    private BigDecimal amountVAT = BigDecimal.ZERO;

    @Column(name = "vATRate")
    private String vATRate = "";

}
