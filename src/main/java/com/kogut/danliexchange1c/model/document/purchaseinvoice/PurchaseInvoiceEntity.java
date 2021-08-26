package com.kogut.danliexchange1c.model.document.purchaseinvoice;

import com.kogut.danliexchange1c.model.document.common.AbstractCommonDocEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author S.Kogut on 10.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "purchase_invoice")
public class PurchaseInvoiceEntity extends AbstractCommonDocEntity {

    @Column(name = "rate")
    private BigDecimal rate = new BigDecimal("1");

    @Column(name = "currency_id")
    private String currencyId = "";

    @Column(name = "date_in")
    private LocalDate dateIn;

    @Column(name = "number_in")
    private String numberIn;

    @Column(name = "agreement_id", length = 36)
    private String agreementId = "";

    @Column(name = "bill_id", length = 36)
    private String billId = "";

    @Column(name = "client_id", length = 36)
    private String clientId = "";

    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "price_id", length = 36)
    private String priceId = "";

    @Column(name = "include_vat")
    private Boolean includeVAT;

    @Column(name = "amount_include_var")
    private Boolean amountIncludeVAT;

    @Column(name = "project_id")
    private String projectId = "";

    @Column(name = "store_id")
    private String storeId = "";

    @Column(name = "customer_account_code")
    private String customerAccountCode = "";

    @Column(name = "customer_account_prepayment_code")
    private String customerAccountPrepaymentCode = "";

    @ElementCollection
    @CollectionTable(name = "purchase_invoice_products_tab", joinColumns = @JoinColumn(name = "purchase_invoice_id"))
    List<PurchaseInvoiceProductsTabEntity> products;

    @ElementCollection
    @CollectionTable(name = "purchase_invoice_services_tab", joinColumns = @JoinColumn(name = "purchase_invoice_id"))
    List<PurchaseInvoiceServicesTabEntity> services;

}
