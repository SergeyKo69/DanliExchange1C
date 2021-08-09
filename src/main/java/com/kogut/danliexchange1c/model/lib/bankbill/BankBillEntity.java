package com.kogut.danliexchange1c.model.lib.bankbill;

import com.kogut.danliexchange1c.enumerations.lib.TypeOwnerBankBillEnum;
import com.kogut.danliexchange1c.model.lib.common.AbstractCommonLibEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author S.Kogut on 09.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "bank_bill")
public class BankBillEntity extends AbstractCommonLibEntity {

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private TypeOwnerBankBillEnum typeOwner;

    @NotEmpty
    @Column(name = "bik")
    private String bik = "";

    @NotEmpty
    @Column(name = "view_bill")
    private String viewBill = "";

    @NotEmpty
    @Column(name = "number_bill")
    private String numberBill = "";

    @Column(name = "currency_id")
    private String currencyId = "";

}
