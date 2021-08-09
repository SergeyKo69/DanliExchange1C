package com.kogut.danliexchange1c.dto.lib.client;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author S.Kogut on 09.08.2021
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClientContactsDTO extends AbstractDTO {

    private String type = "";
    private String view = "";
    private String representation = "";
    private String field1 = "";
    private String field2 = "";
    private String field3 = "";
    private String field4 = "";
    private String field5 = "";
    private String field6 = "";
    private String field7 = "";
    private String field8 = "";
    private String field9 = "";
    private String field10 = "";
    private String comment = "";
    private String typeHouse = "";
    private String typeFrame = "";
    private String typeFlat = "";
}
