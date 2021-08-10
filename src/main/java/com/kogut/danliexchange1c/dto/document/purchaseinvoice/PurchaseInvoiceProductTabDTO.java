package com.kogut.danliexchange1c.dto.document.purchaseinvoice;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author S.Kogut on 10.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PurchaseInvoiceProductTabDTO extends AbstractDTO {

    private String productId = "";
    private String unitId = "";
    private BigDecimal quantitySeats = BigDecimal.ZERO;
    private BigDecimal quantity = BigDecimal.ZERO;
    private String unitSeatsId = "";
    private Integer rateVat = 20;
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal amountVat = BigDecimal.ZERO;
    private BigDecimal price = BigDecimal.ZERO;
    private String storeId = "";
    private String gtdId = "";
    private String countryId = "";
    private String content = "";
    private String articleId = "";

}
