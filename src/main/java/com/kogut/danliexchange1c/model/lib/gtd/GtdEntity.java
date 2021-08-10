package com.kogut.danliexchange1c.model.lib.gtd;

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
@Table(name = "gtd")
public class GtdEntity extends AbstractCommonLibEntity {

    @Column(name = "product_id", length = 36)
    private String productId = "";

    @Column(name = "number")
    private String number = "";

}
