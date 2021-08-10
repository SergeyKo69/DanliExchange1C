package com.kogut.danliexchange1c.dto.document.purchaseinvoice;

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
public class PurchaseInvoiceDTO extends AbstractCommonDocDTO {

    private String currencyId = "";
    private LocalDate dateIn;
    private String numberIn;
    private String agreementId = "";
    private String billId = "";
    private String clientId = "";
    private BigDecimal amount = BigDecimal.ZERO;
    private String priceId = "";
    private Boolean includeVAT;
    private String projectId = "";
    private String storeId = "";

    private List<PurchaseInvoiceProductTabDTO> products = new ArrayList<>();
    private List<PurchaseinvoiceServicesTabDTO> services = new ArrayList<>();

}
