package com.kogut.danliexchange1c.model.lib.client;

import com.kogut.danliexchange1c.model.lib.common.AbstractCommonLibEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author S.Kogut on 09.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "client")
public class ClientEntity extends AbstractCommonLibEntity {

    @Column(name = "inn", length = 12)
    private String INN = "";

    @Column(name = "cod_po_okpo", length = 12)
    private String codPoOkpo = "";

    @Column(name = "comment")
    private String comment = "";

    @Column(name = "kpp", length = 9)
    private String kpp = "";

    @Column(name = "full_name")
    private String fullName = "";

    @Column(name = "ur_phis_face")
    private String urPhisFace = "";

    @Column(name = "country_Id")
    private String countryId = "";

    @Column(name = "bank_bill_id")
    private String bankBillId = "";

    @ElementCollection
    @CollectionTable(name = "client_contacts", joinColumns = @JoinColumn(name = "client_id"))
    private List<ClientContactsEntity> contacts;

}
