package com.kogut.danliexchange1c.model.document.invoice;

import com.kogut.danliexchange1c.model.document.common.AbstractCommonDocTabEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Embeddable
public class InvoiceProductsTabEntity extends AbstractCommonDocTabEntity {

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
