package com.kogut.danliexchange1c.dto.document.receiptcashorder;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author S.Kogut on 11.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReceiptCashPaymentDecriptionTabDTO extends AbstractDTO {

    private String agreementId = "";
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal multiplicity = BigDecimal.ZERO;
    private BigDecimal amountVR = BigDecimal.ZERO;
    private Integer rateVat = 20;
    private BigDecimal amountVat = BigDecimal.ZERO;
    private String articleId = "";
    private String projectDecriptionId = "";
    private String docRView = "";
    private String docRId = "";
    private ReceiptCashBaseDocDTO docR = new ReceiptCashBaseDocDTO();

}
