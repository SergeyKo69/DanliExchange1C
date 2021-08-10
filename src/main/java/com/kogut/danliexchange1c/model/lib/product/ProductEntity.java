package com.kogut.danliexchange1c.model.lib.product;

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
@Table(name = "product")
public class ProductEntity extends AbstractCommonLibEntity {

    @Column(name = "artikul")
    private String artikul = "";

    @Column(name = "full_name")
    private String fullName = "";

    @Column(name = "unit_id", length = 36)
    private String unitId = "";

    @Column(name = "rate_vat")
    private Integer rateVat = 20;

    @Column(name = "country_id", length = 36)
    private String countryId = "";

    @Column(name = "gtd_id", length = 36)
    private String gtdId = "";

    @Column(name = "view_product_id", length = 36)
    private String viewProductId = "";

    @Column(name = "tnved_id")
    private String tnvedId = "";

}
