package com.kogut.danliexchange1c.model.lib.agreement;

import com.kogut.danliexchange1c.enumerations.lib.TypeAgreementEnum;
import com.kogut.danliexchange1c.model.lib.common.AbstractCommonLibEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author S.Kogut on 10.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "agreement")
public class AgreementEntity extends AbstractCommonLibEntity {

    @NotNull
    @NotEmpty
    @Enumerated(EnumType.STRING)
    private TypeAgreementEnum type;

    @Column(name = "currency_id")
    private String currencyId = "";

    @Column(name = "number")
    private String number = "";

    @Column(name = "date")
    private LocalDate date;

}
