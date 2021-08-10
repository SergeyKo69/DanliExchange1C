package com.kogut.danliexchange1c.model.document.purchaseinvoice;

import com.kogut.danliexchange1c.model.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * @author S.Kogut on 10.08.2021
 */

@Getter
@Setter
@Embeddable
public class PurchaseInvoiceServicesTabEntity extends AbstractEntity {

    @Column(name = "priduct_id", length = 36)
    private String productId = "";

    @Column(name = "quantity")
    private BigDecimal quantity = BigDecimal.ZERO;

    @Column(name = "content")
    private String content = "";

    @Column(name = "rate_vat")
    private Integer rateVat = 20;

    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "amount_vat")
    private BigDecimal amountVat = BigDecimal.ZERO;

    @Column(name = "price")
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "article_id", length = 36)
    private String articleId = "";

}
