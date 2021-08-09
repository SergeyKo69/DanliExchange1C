package com.kogut.danliexchange1c.dto.lib.client;

import com.kogut.danliexchange1c.dto.lib.common.AbstractCommonLibDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Kogut on 09.08.2021
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ClientDTO extends AbstractCommonLibDTO {

    private String INN = "";
    private String codPoOkpo = "";
    private String comment = "";
    private String kpp = "";
    private String fullName = "";
    private String urPhisFace = "";
    private String countryId = "";
    private String bankBillId = "";

    private List<ClientContactsDTO> contacts = new ArrayList<>();
}
