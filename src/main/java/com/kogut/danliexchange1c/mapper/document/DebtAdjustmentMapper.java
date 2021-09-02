package com.kogut.danliexchange1c.mapper.document;

import com.kogut.danliexchange1c.dto.document.debtadjustment.DebtAdjustmentCreditDebtTabDTO;
import com.kogut.danliexchange1c.dto.document.debtadjustment.DebtAdjustmentDTO;
import com.kogut.danliexchange1c.dto.document.debtadjustment.DebtAdjustmentDebetDebtTabDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.debtadjustment.DebtAdjustmentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

/**
 * @author S.Kogut on 02.09.2021
 */

@Component
public class DebtAdjustmentMapper extends AbstractMapper<DebtAdjustmentEntity, DebtAdjustmentDTO> {

    private final ModelMapper mapper;

    @Autowired
    public DebtAdjustmentMapper(ModelMapper mapper) {
        super(DebtAdjustmentEntity.class, DebtAdjustmentDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(DebtAdjustmentDTO.class, DebtAdjustmentEntity.class)
                .addMappings(m -> m.skip(DebtAdjustmentEntity :: setId))
                .addMappings(m -> m.skip(DebtAdjustmentEntity :: setClientDB))
                .setPostConverter(toEntityConverter());
        mapper.createTypeMap(DebtAdjustmentEntity.class, DebtAdjustmentDTO.class)
                .setPostConverter(toDtoConverter());
    }

    @Override
    public void mapSpecificFields(DebtAdjustmentEntity source, DebtAdjustmentDTO destination) {
        super.mapSpecificFields(source, destination);
        destination.setDebetDebt(source.getDebetDebt()
                .stream()
                .map(item -> mapper.map(item, DebtAdjustmentDebetDebtTabDTO.class))
                .collect(Collectors.toList())
        );
        destination.setCreditDebt(source.getCreditDebt()
                .stream()
                .map(item -> mapper.map(item, DebtAdjustmentCreditDebtTabDTO.class))
                .collect(Collectors.toList())
        );
    }

    @Override
    public void mapSpecificFields(DebtAdjustmentDTO source, DebtAdjustmentEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
    }
}
