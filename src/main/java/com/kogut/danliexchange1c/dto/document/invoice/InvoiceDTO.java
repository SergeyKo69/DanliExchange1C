package com.kogut.danliexchange1c.dto.document.invoice;

import com.kogut.danliexchange1c.dto.document.common.AbstractCommonDocDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author S.Kogut on 23.07.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InvoiceDTO extends AbstractCommonDocDTO {

    private LocalDate dateSend;
    private String operationView = "";
    private String deliveryAddressId = "";
    private String accountBillId = "";
    private String shipperId = "";
    private String consigneeId = "";
    private String agreementId = "";
    private String clientId = "";
    private String projectId = "";
    private String storeId = "";
    private String priceId = "";
    private Boolean amountIncludeNDS;
    private BigDecimal amount = BigDecimal.ZERO;
    private Boolean includeVAT;
    private String documentBaseId = "";
    private Boolean byOrder;
    private String carrierCMRId = "";
    private String numberCMRPL = "";
    private LocalDate dateCMRPL;
    private String driverFIOCMR = "";
    private String numberCarCMR = "";
    private String modelCarCMR = "";
    private String termsOfPaymentCMR = "";
    private Boolean orderCancel;
    private String numberOrder;
    private LocalDate dateOrder;

}
