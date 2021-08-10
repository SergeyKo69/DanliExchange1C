package com.kogut.danliexchange1c.dto.document.invoiceissued;

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
public class InvoiceIssuedPrepaymentTabDTO extends AbstractDTO {

    private String productId = "";
    private String content = "";
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal amountVat = BigDecimal.ZERO;
    private Integer rateVat = 20;

}
