package com.kogut.danliexchange1c.model.lib.common;

import com.kogut.danliexchange1c.enumerations.lib.TypeOwnerGroupLibEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author S.Kogut on 09.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "group_lib")
public class GroupLibEntity extends AbstractCommonLibEntity {

    @NotNull
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private TypeOwnerGroupLibEnum typeOwnerGroup;

}
