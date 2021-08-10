package com.kogut.danliexchange1c.model.document.invoiceissued;

import com.kogut.danliexchange1c.model.document.common.AbstractCommonDocEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "invoice_issued")
public class InvoiceIssuedEntity extends AbstractCommonDocEntity {

    @Column(name = "correction")
    private Boolean correction;

    @Column(name = "code_view_operation")
    private String codeViewOperation = "";

    @Column(name = "kpp_client")
    private String kppClient = "";

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    @Column(name = "client_id", length = 36)
    private String clientId;

    @Column(name = "agreement_id", length = 36)
    private String agreementId = "";

    @Column(name = "view_invoice_issued")
    private String viewInvoiceIssued = "";

    @Column(name = "doc_owner_id", length = 36)
    private String docOwnerId = "";

    @Column(name = "doc_owner_view")
    private String docOwnerView = "";

    @Column(name = "view_operation_doc_owner")
    private String viewOperationDocOwner = "";

    @Column(name = "rate_vat")
    private Integer rateVat = 20;

    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "amount_vat")
    private BigDecimal amountVat = BigDecimal.ZERO;

    @Column(name = "date_payment_settlement_doc")
    private LocalDate datePaymentSettlementDoc;

    @Column(name = "number_payment_settlement_doc")
    private String numberPaymentSettlementDoc = "";

    @Column(name = "number_correction")
    private String numberCorrection = "";

    @Column(name = "amount_doc")
    private BigDecimal amountDoc = BigDecimal.ZERO;

    @Column(name = "amount_vat_doc")
    private BigDecimal amountVatDoc = BigDecimal.ZERO;

    @ElementCollection
    @CollectionTable(name = "invoice_issued_prepayment_tab", joinColumns = @JoinColumn(name = "invoiceIssuedId"))
    private List<InvoiceIssuedPrepaymentTabEntity> prepayment = new ArrayList<>();

}
