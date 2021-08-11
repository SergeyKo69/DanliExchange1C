package com.kogut.danliexchange1c.model.document.receiptcashorder;

import com.kogut.danliexchange1c.model.document.common.AbstractCommonDocEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author S.Kogut on 11.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "receipt_cash_order")
public class ReceiptCashOrderEntity extends AbstractCommonDocEntity {

    @Column(name = "view_operation")
    private String viewOperation = "";

    @Column(name = "client_id", length = 36)
    private String clientId = "";

    @Column(name = "agreement_id", length = 36)
    private String agreementId = "";

    @Column(name = "amount_doc")
    private BigDecimal amountDoc = BigDecimal.ZERO;

    @Column(name = "taken_from")
    private String takenFrom = "";

    @Column(name = "base")
    private String base = "";

    @Column(name = "appendix")
    private String appendix = "";

    @Column(name = "paid")
    private Boolean paid;

    @Column(name = "base_doc_id", length = 36)
    private String baseDocId = "";

    @Column(name = "base_doc_view")
    private String baseDocView = "";

    @Column(name = "base_doc_view_operation")
    private String baseDocViewOperation = "";

    @Column(name = "bill_id", length = 36)
    private String billId = "";

    @Column(name = "rate_vat")
    private Integer rateVat = 20;

    @Embedded
    private ReceiptCashBaseDocEntity baseDoc;

    @ElementCollection
    @CollectionTable(name = "receipt_cash_payment_decription_tab", joinColumns = @JoinColumn(name = "receipt_cash_order"))
    private List<ReceiptCashPaymentDecriptionTabEntity> cashDecription;

}
