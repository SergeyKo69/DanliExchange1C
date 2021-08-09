package com.kogut.danliexchange1c.model.lib.client;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 * @author S.Kogut on 09.08.2021
 */

@Getter
@Setter
@Embeddable
@Table(name = "client_contacts")
public class ClientContactsEntity {

    @Column(name = "type")
    private String type = "";

    @Column(name = "view")
    private String view = "";

    @Column(name = "representation")
    private String representation = "";

    @Column(name = "field1")
    private String field1 = "";

    @Column(name = "field2")
    private String field2 = "";

    @Column(name = "field3")
    private String field3 = "";

    @Column(name = "field4")
    private String field4 = "";

    @Column(name = "field5")
    private String field5 = "";

    @Column(name = "field6")
    private String field6 = "";

    @Column(name = "field7")
    private String field7 = "";

    @Column(name = "field8")
    private String field8 = "";

    @Column(name = "field9")
    private String field9 = "";

    @Column(name = "field10")
    private String field10 = "";

    @Column(name = "comment")
    private String comment = "";

    @Column(name = "typeHouse")
    private String typeHouse = "";

    @Column(name = "typeFrame")
    private String typeFrame = "";

    @Column(name = "typeFlat")
    private String typeFlat = "";

}
