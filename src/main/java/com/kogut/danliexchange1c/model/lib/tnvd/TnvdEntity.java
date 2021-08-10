package com.kogut.danliexchange1c.model.lib.tnvd;

import com.kogut.danliexchange1c.model.lib.common.AbstractCommonLibEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author S.Kogut on 11.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tnvd")
public class TnvdEntity extends AbstractCommonLibEntity {
}
