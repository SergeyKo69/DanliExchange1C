package com.kogut.danliexchange1c.dto.document.common;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * @author S.Kogut on 23.07.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractCommonDocDTO extends AbstractDTO {

    private String externalId = "";
    private String numberDoc = "";
    private LocalDateTime dateDoc;
    private Boolean record;
    private Boolean deleted;
    private String comment = "";

}
