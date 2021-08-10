package com.kogut.danliexchange1c.model.lib.price;

import com.kogut.danliexchange1c.model.lib.common.AbstractCommonLibEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author S.Kogut on 10.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "price")
public class PriceEntity extends AbstractCommonLibEntity {

    @Column(name = "include_vat")
    private Boolean includeVat;

    @Column(name = "currency_id")
    private String currencyId = "";

    @Column(name = "comment")
    private String comment = "";

}
