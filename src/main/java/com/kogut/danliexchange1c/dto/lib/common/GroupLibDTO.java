package com.kogut.danliexchange1c.dto.lib.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author S.Kogut on 09.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GroupLibDTO extends AbstractCommonLibDTO {

    @NotNull
    @NotEmpty
    private String typeOwnerGroup;

}
