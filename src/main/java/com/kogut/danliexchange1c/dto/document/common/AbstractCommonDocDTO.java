package com.kogut.danliexchange1c.dto.document.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author S.Kogut on 23.07.2021
 */

@Data
@EqualsAndHashCode
@NoArgsConstructor
public abstract class AbstractCommonDocDTO {

    private String externalId = "";
    private String numberDoc = "";
    private LocalDateTime dateDoc;
    private Boolean record;
    private Boolean deleted;
    private String comment = "";

}
