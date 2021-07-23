package com.kogut.danliexchange1c.dto.document.invoice;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author S.Kogut on 23.07.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InvoiceServicesTabDTO extends AbstractDTO {

    private String productId = "";
    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal amountVAT = BigDecimal.ZERO;
    private String vATRate = "";

}
