package com.kogut.danliexchange1c.dto.document.invoicereceived;

import com.kogut.danliexchange1c.dto.document.common.AbstractCommonDocDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author S.Kogut on 11.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvoiceReceivedDTO extends AbstractCommonDocDTO {

    private String view = "";
    private LocalDate correctionDate;
    private String clientId = "";
    private String agreementId = "";
    private LocalDate dateOriginalDoc;
    private Boolean correction;
    private String codeViewOperation = "";
    private String ownerDocId = "";
    private String ownerViewDoc = "";
    private String viewOperationOwnerDoc = "";
    private String numberCorrection = "";
    private String numberOriginalDoc = "";
    private String sellerId = "";
    private LocalDate dateDocIn;
    private String numberDocIn = "";
    private BigDecimal amountVatDoc = BigDecimal.ZERO;
    private BigDecimal amountDoc = BigDecimal.ZERO;
    private String kppClient = "";
    private String codeViewOperationDecrease = "";

}
