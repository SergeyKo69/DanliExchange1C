package com.kogut.danliexchange1c.dto.lib.product;

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
public class ProductDTO extends AbstractCommonLibDTO {

    private String artikul = "";
    private String fullName = "";
    private String unitId = "";
    private Integer rateVat = 20;
    private String countryId = "";
    private String gtdId = "";
    private String viewProductId = "";
    private String tnvedId = "";

}
