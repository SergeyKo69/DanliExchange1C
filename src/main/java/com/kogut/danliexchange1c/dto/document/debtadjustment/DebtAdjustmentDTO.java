package com.kogut.danliexchange1c.dto.document.debtadjustment;

import com.kogut.danliexchange1c.dto.document.common.AbstractCommonDocDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Kogut on 02.09.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DebtAdjustmentDTO extends AbstractCommonDocDTO {

    private String viewOperation = "";
    private String currencyId = "";
    private BigDecimal documentRate = new BigDecimal(1);
    private Integer documentMultiplicity = 1;
    private String clientDebtId = "";
    private String clientCreditId = "";
    private Boolean useSatelliteAccount;
    private String billDebtId = "";
    private String subcontoDt1Id = "";
    private String subcontoDt2Id = "";
    private String subcontoDt3Id = "";
    private String billCreditId = "";
    private String subcontCt1Id = "";
    private String subcontCt2Id = "";
    private String subcontCt3Id = "";
    private BigDecimal amountCtDebt = BigDecimal.ZERO;
    private BigDecimal amountDtDebt = BigDecimal.ZERO;

    List<DebtAdjustmentDebetDebtTabDTO> debetDebt = new ArrayList<>();

}
