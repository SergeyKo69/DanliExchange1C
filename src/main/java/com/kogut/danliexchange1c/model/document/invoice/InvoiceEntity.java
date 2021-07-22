package com.kogut.danliexchange1c.model.document.invoice;

import com.kogut.danliexchange1c.model.document.common.AbstractCommonDocEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "invoice")
public class InvoiceEntity extends AbstractCommonDocEntity {

    @Column(name = "dateSend")
    private LocalDate dateSend;

    @Column(name = "operationView")
    private String operationView = "";

    @Column(name = "deliveryAddressId")
    private String deliveryAddressId = "";

    @Column(name = "accountBillId")
    private String accountBillId = "";

    @Column(name = "shipperId")
    private String shipperId = "";

    @Column(name = "consigneeId")
    private String consigneeId = "";

    @Column(name = "agreementId")
    private String agreementId = "";

    @Column(name = "clientId")
    private String clientId = "";

    @Column(name = "projectId")
    private String projectId = "";

    @Column(name = "storeId")
    private String storeId = "";

    @Column(name = "priceId")
    private String priceId = "";

    @Column(name = "amountIncludeVAT")
    private Boolean amountIncludeNDS;

    @Column(name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "includeVAT")
    private Boolean includeVAT;

    @Column(name = "documentBaseId")
    private String documentBaseId = "";

    @Column(name = "byOrder")
    private Boolean byOrder;

    @Column(name = "carrierCMRId")
    private String carrierCMRId = "";

    @Column(name = "numberCMRPL")
    private String numberCMRPL = "";

    @Column(name = "dateCMRPL")
    private LocalDate dateCMRPL;

    @Column(name = "driverFIOCMR")
    private String driverFIOCMR = "";

    @Column(name = "numberCarCMR")
    private String numberCarCMR = "";

    @Column(name = "modelCarCMR")
    private String modelCarCMR = "";

    @Column(name = "termsOfPaymentCMR")
    private String termsOfPaymentCMR = "";

    @Column(name = "orderCancel")
    private Boolean orderCancel;

    @ElementCollection
    @CollectionTable(name = "invoiceProductsTab", joinColumns = @JoinColumn(name = "invoiceId"))
    private List<InvoiceProductsTabEntity> products;

    @ElementCollection
    @CollectionTable(name = "invoiceServicesTab", joinColumns = @JoinColumn(name = "invoiceId"))
    private List<InvoiceServicesTabEntity> services;

}
