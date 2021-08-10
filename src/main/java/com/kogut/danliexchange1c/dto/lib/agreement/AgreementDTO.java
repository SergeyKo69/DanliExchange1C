package com.kogut.danliexchange1c.dto.lib.agreement;

import com.kogut.danliexchange1c.dto.lib.common.AbstractCommonLibDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author S.Kogut on 10.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AgreementDTO extends AbstractCommonLibDTO {

    @NotNull
    @NotEmpty
    private String type;
    private String currencyId = "";
    private String number = "";
    private LocalDate date;

}
