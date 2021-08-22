package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.bankbill.BankBillDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.enumerations.lib.TypeOwnerBankBillEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.bankbill.BankBillEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author S.Kogut on 09.08.2021
 */

@Component
public class BankBillMapper extends AbstractMapper<BankBillEntity, BankBillDTO> {

    private final ModelMapper mapper;

    @Autowired
    public BankBillMapper(ModelMapper mapper) {
        super(BankBillEntity.class, BankBillDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(BankBillDTO.class, BankBillEntity.class)
                .addMappings(m -> m.skip(BankBillEntity:: setId))
                .addMappings(m -> m.skip(BankBillEntity::setClientDB))
                .setPostConverter(toEntityConverter());
        mapper.createTypeMap(BankBillEntity.class, BankBillDTO.class)
                .setPostConverter(toDtoConverter());
    }

    @Override
    public void mapSpecificFields(BankBillEntity source, BankBillDTO destination) {
        super.mapSpecificFields(source, destination);
        destination.setTypeOwner(source.getTypeOwner().toString());
    }

    @Override
    public void mapSpecificFields(BankBillDTO source, BankBillEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
        destination.setTypeOwner(TypeOwnerBankBillEnum.valueOf(source.getTypeOwner()));
    }

}
