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

    @Column(name = "codPoOkpo", length = 12)
    private String codPoOkpo = "";

    @Column(name = "comment")
    private String comment = "";

    @Column(name = "kpp", length = 9)
    private String kpp = "";

    @Column(name = "fullName")
    private String fullName = "";

    @Column(name = "urPhisFace")
    private String urPhisFace = "";

    @Column(name = "countryId")
    private String countryId = "";

    @Column(name = "bankBillId")
    private String bankBillId = "";

    @ElementCollection
    @CollectionTable(name = "clientContacts", joinColumns = @JoinColumn(name = "clientId"))
    private List<ClientContactsEntity> contacts;

}
