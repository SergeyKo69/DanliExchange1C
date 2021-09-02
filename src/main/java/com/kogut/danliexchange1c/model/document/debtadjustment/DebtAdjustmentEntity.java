package com.kogut.danliexchange1c.model.document.debtadjustment;

import com.kogut.danliexchange1c.model.document.common.AbstractCommonDocEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Kogut on 02.09.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "debt_adjustment")
public class DebtAdjustmentEntity extends AbstractCommonDocEntity {

    @Column(name = "view_operation")
    private String viewOperation = "";

    @Column(name = "currency_id")
    private String currencyId = "";

    @Column(name = "document_rate")
    private BigDecimal documentRate = new BigDecimal(1);

    @Column(name = "document_multiplicity")
    private Integer documentMultiplicity = 1;

    @Column(name = "client_debt_id", length = 36)
    private String clientDebtId = "";

    @Column(name = "client_credit_id", length = 36)
    private String clientCreditId = "";

    @Column(name = "use_satellite_account")
    private Boolean useSatelliteAccount;

    @Column(name = "bill_debt_id", length = 36)
    private String billDebtId = "";

    @Column(name = "subconto_dt_1_id", length = 36)
    private String subcontoDt1Id = "";

    @Column(name = "subconto_dt_2_id", length = 36)
    private String subcontoDt2Id = "";

    @Column(name = "subconto_dt_3_id", length = 36)
    private String subcontoDt3Id = "";

    @Column(name = "bill_credit_id", length = 36)
    private String billCreditId = "";

    @Column(name = "subconto_ct_1_id", length = 36)
    private String subcontCt1Id = "";

    @Column(name = "subconto_ct_2_id", length = 36)
    private String subcontCt2Id = "";

    @Column(name = "subconto_ct_3_id", length = 36)
    private String subcontCt3Id = "";

    @Column(name = "amount_ct_debt")
    private BigDecimal amountCtDebt = BigDecimal.ZERO;

    @Column(name = "amount_dt_debt")
    private BigDecimal amountDtDebt = BigDecimal.ZERO;

    @ElementCollection
    @CollectionTable(name = "debt_adjustment_debet_debt_tab", joinColumns = @JoinColumn(name = "debt_adjustment_id"))
    List<DebtAdjustmentDebetDebtTabEntity> debetDebt = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "debt_adjustment_credit_debt_tab", joinColumns = @JoinColumn(name = "debt_adjustment_id"))
    List<DebtAdjustmentCreditDebtTabEntity> creditDebt = new ArrayList<>();

}
