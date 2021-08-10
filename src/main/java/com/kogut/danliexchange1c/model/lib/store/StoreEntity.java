package com.kogut.danliexchange1c.model.lib.store;

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
@Table(name = "store")
public class StoreEntity extends AbstractCommonLibEntity {

    @Column(name = "price_id")
    private String priceId = "";

}
