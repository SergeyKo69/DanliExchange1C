package com.kogut.danliexchange1c.dto.document.invoiceissued;

import com.kogut.danliexchange1c.dto.document.common.AbstractCommonDocDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvoiceIssuedDTO extends AbstractCommonDocDTO {

    private Boolean correction;
    private String codeViewOperation = "";
    private String kppClient = "";
    private LocalDate dateOfIssue;
    private String clientId;
    private String agreementId = "";
    private String viewInvoiceIssued = "";
    private String docOwnerId = "";
    private String docOwnerView = "";
    private String viewOperationDocOwner = "";
    private Integer rateVat = 20;
    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal amountVat = BigDecimal.ZERO;
    private LocalDate datePaymentSettlementDoc;
    private String numberPaymentSettlementDoc = "";
    private String numberCorrection = "";
    private BigDecimal amountDoc = BigDecimal.ZERO;
    private BigDecimal amountVatDoc = BigDecimal.ZERO;
    private List<InvoiceIssuedPrepaymentTabDTO> prepayment = new ArrayList<>();
}
