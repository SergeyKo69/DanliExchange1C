package com.kogut.danliexchange1c.dto.lib.common;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author S.Kogut on 03.08.2021
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractCommonLibDTO extends AbstractDTO {

    private String externalId = "";
    private String code = "";
    private String name = "";
    private String parentId = "";
    private String ownerId = "";
    private Boolean deleted;

    @NotNull
    @NotEmpty
    private String clientDB;

}
