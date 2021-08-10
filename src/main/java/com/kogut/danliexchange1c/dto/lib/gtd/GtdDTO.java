package com.kogut.danliexchange1c.dto.lib.gtd;

import com.kogut.danliexchange1c.dto.lib.common.AbstractCommonLibDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author S.Kogut on 10.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GtdDTO extends AbstractCommonLibDTO {

    private String productId = "";
    private String number = "";

}
