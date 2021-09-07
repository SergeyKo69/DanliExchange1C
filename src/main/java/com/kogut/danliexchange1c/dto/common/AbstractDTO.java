package com.kogut.danliexchange1c.dto.common;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author S.Kogut on 23.07.2021
 */

@Data
public abstract class AbstractDTO {

    @NotNull
    @NotEmpty
    private String clientDB;

}
