package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.agreement.AgreementDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.enumerations.lib.TypeAgreementEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.agreement.AgreementEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class AgreementMapper extends AbstractMapper<AgreementEntity, AgreementDTO> {

    private final ModelMapper mapper;

    @Autowired
    public AgreementMapper(ModelMapper mapper) {
        super(AgreementEntity.class, AgreementDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(AgreementDTO.class, AgreementEntity.class)
                .addMappings(m -> m.skip(AgreementEntity:: setId))
                .addMappings(m -> m.skip(AgreementEntity::setClientDB));
    }

    @Override
    public void mapSpecificFields(AgreementEntity source, AgreementDTO destination) {
        super.mapSpecificFields(source, destination);
    }

    @Override
    public void mapSpecificFields(AgreementDTO source, AgreementEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
        destination.setType(TypeAgreementEnum.valueOf(source.getType()));
    }

}
