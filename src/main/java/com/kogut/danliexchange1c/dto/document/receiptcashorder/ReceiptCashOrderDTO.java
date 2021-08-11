package com.kogut.danliexchange1c.dto.document.receiptcashorder;

import com.kogut.danliexchange1c.dto.document.common.AbstractCommonDocDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Kogut on 11.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ReceiptCashOrderDTO extends AbstractCommonDocDTO {

    private String viewOperation = "";
    private String clientId = "";
    private String agreementId = "";
    private BigDecimal amountDoc = BigDecimal.ZERO;
    private String takenFrom = "";
    private String base = "";
    private String appendix = "";
    private Boolean paid;
    private String baseDocId = "";
    private String baseDocView = "";
    private String baseDocViewOperation = "";
    private String billId = "";
    private Integer rateVat = 20;
    private ReceiptCashBaseDocDTO baseDoc = new ReceiptCashBaseDocDTO();

    private List<ReceiptCashPaymentDecriptionTabDTO> cashDecription = new ArrayList<>();

}
