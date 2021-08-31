package com.kogut.danliexchange1c.dto.document.bankstatement;

import com.kogut.danliexchange1c.dto.document.common.AbstractCommonDocDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Kogut on 12.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BankStatementDTO extends AbstractCommonDocDTO {

    private String viewOperation = "";
    private String agreementId = "";
    private String baseDocId = "";
    private String baseDocView = "";
    private String baseDocViewOperation = "";
    private String clientId = "";
    private String numberIn = "";
    private LocalDate dateIn;
    private Boolean paid;
    private LocalDate datePaid;
    private String billIdClient;
    private String billIdOrganisation;
    private String purposeOfPayment;
    private BigDecimal amountDoc = BigDecimal.ZERO;
    private String numberCheck = "";
    private String articleId = "";
    private String currencyId = "";
    private BankStatementBaseDocDTO baseDoc = new BankStatementBaseDocDTO();

    private List<BankStatementDecriptionTabDTO> cashDecription = new ArrayList<>();

}
