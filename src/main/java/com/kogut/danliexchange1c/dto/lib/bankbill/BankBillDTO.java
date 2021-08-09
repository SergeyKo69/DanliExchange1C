package com.kogut.danliexchange1c.dto.lib.bankbill;

import com.kogut.danliexchange1c.dto.lib.common.AbstractCommonLibDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @author S.Kogut on 09.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BankBillDTO extends AbstractCommonLibDTO {

    @NotEmpty
    private String typeOwner = "";

    @NotEmpty
    private String bik = "";

    @NotEmpty
    private String viewBill = "";

    @NotEmpty
    private String numberBill = "";

    private String currencyId = "";

}
