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
public class PurchaseinvoiceServicesTabDTO extends AbstractDTO {

    private String productId = "";
    private BigDecimal quantity = BigDecimal.ZERO;
    private String content = "";
    private Integer rateVat = 20;
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal amountVat = BigDecimal.ZERO;
    private BigDecimal price = BigDecimal.ZERO;
    private String articleId = "";
    private String codeExpenseAccount = "";
    private String subconto1id = "";
    private String subconto2id = "";
    private String subconto3id = "";

}
