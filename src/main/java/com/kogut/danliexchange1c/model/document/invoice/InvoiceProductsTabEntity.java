package com.kogut.danliexchange1c.model.document.invoice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Embeddable
public class InvoiceProductsTabEntity {

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

    @Column(name = "quantitySeats")
    private BigDecimal quantitySeats = BigDecimal.ZERO;

    @Column(name = "unitId")
    private String unitId = "";

    @Column(name = "unitIdSeats")
    private String unitIdSeats = "";

    @Column(name = "storeId")
    private String storeId = "";

    @Column(name = "gtdId")
    private String gtdId = "";

    @Column(name = "tNVEDId")
    private String tNVEDId = "";

    @Column(name = "content")
    private String content = "";

}
