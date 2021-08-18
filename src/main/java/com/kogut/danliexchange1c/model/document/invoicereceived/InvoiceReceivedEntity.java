package com.kogut.danliexchange1c.model.document.invoicereceived;

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
 * @author S.Kogut on 11.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "invoice_received")
public class InvoiceReceivedEntity extends AbstractCommonDocEntity {

    @Column(name = "view")
    private String view = "";

    @Column(name = "correction_date")
    private LocalDate correctionDate;

    @Column(name = "client_id")
    private String clientId = "";

    @Column(name = "agreement_id")
    private String agreementId = "";

    @Column(name = "date_original_doc")
    private LocalDate dateOriginalDoc;

    @Column(name = "correction")
    private Boolean correction;

    @Column(name = "code_view_operation")
    private String codeViewOperation = "";

    @Column(name = "owner_doc_id")
    private String ownerDocId = "";

    @Column(name = "owner_view_doc")
    private String ownerViewDoc = "";

    @Column(name = "view_operation_owner_doc")
    private String viewOperationOwnerDoc = "";

    @Column(name = "number_correction")
    private String numberCorrection = "";

    @Column(name = "number_original_doc")
    private String numberOriginalDoc = "";

    @Column(name = "seller_id")
    private String sellerId = "";

    @Column(name = "date_doc_in")
    private LocalDate dateDocIn;

    @Column(name = "number_doc_in")
    private String numberDocIn = "";

    @Column(name = "amount_vat_doc")
    private BigDecimal amountVatDoc = BigDecimal.ZERO;

    @Column(name = "amount_doc")
    private BigDecimal amountDoc = BigDecimal.ZERO;

    @Column(name = "kpp_client")
    private String kppClient = "";

    @Column(name = "code_view_operation_decrease")
    private String codeViewOperationDecrease = "";

    @ElementCollection
    @CollectionTable(name = "invoice_received_payment_tab", joinColumns = @JoinColumn(name = "invoice_received_id"))
    private List<InvoiceReceivedPrepaymentTabEntity> prepayment = new ArrayList<>();;

}
