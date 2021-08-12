package com.kogut.danliexchange1c.mapper.document;

import com.kogut.danliexchange1c.dto.document.bankstatement.BankStatementBaseDocDTO;
import com.kogut.danliexchange1c.dto.document.bankstatement.BankStatementDTO;
import com.kogut.danliexchange1c.dto.document.bankstatement.BankStatementDecriptionTabDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.bankstatement.BankStatementBaseDocEntity;
import com.kogut.danliexchange1c.model.document.bankstatement.BankStatementDecriptionTabEntity;
import com.kogut.danliexchange1c.model.document.bankstatement.BankStatementEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author S.Kogut on 12.08.2021
 */

@Component
public class BankStatementMapper extends AbstractMapper<BankStatementEntity, BankStatementDTO> {

    private final ModelMapper mapper;

    @Autowired
    public BankStatementMapper(ModelMapper mapper) {
        super(BankStatementEntity.class, BankStatementDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(BankStatementDTO.class, BankStatementEntity.class)
                .addMappings(m -> m.skip(BankStatementEntity :: setId))
                .addMappings(m -> m.skip(BankStatementEntity :: setClientDB));
    }

    @Override
    public void mapSpecificFields(BankStatementEntity source, BankStatementDTO destination) {
        super.mapSpecificFields(source, destination);
        source.setBaseDoc(mapper.map(destination.getBaseDoc(), BankStatementBaseDocEntity.class));
        Set<BankStatementDecriptionTabDTO> cashDecription = new HashSet<>();
        List<BankStatementDecriptionTabEntity> cashDecriptionE = source.getCashDecription();
        if (cashDecriptionE != null) {
            cashDecriptionE.forEach(cash -> {
                BankStatementDecriptionTabDTO cashDecriptionDTO =
                        mapper.map(cash, BankStatementDecriptionTabDTO.class);
                BankStatementBaseDocEntity baseDoc = cash.getDocR();
                if (baseDoc != null) {
                    cashDecriptionDTO.setDocR(mapper.map(baseDoc, BankStatementBaseDocDTO.class));
                }
                cashDecription.add(cashDecriptionDTO);
            });
            destination.setCashDecription(new ArrayList<>(cashDecription));
        }
    }

    @Override
    public void mapSpecificFields(BankStatementDTO source, BankStatementEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
        source.setBaseDoc(mapper.map(destination.getBaseDoc(), BankStatementBaseDocDTO.class));
        Set<BankStatementDecriptionTabEntity> cashDecription = new HashSet<>();
        List<BankStatementDecriptionTabDTO> cashDecriptionDTO = source.getCashDecription();
        if (cashDecriptionDTO != null) {
            cashDecriptionDTO.forEach(cash -> {
                BankStatementDecriptionTabEntity cashDecriptionE =
                        mapper.map(cash, BankStatementDecriptionTabEntity.class);
                BankStatementBaseDocDTO baseDoc = cash.getDocR();
                if (baseDoc != null) {
                    cashDecriptionE.setDocR(mapper.map(baseDoc, BankStatementBaseDocEntity.class));
                }
                cashDecription.add(cashDecriptionE);
            });
            destination.setCashDecription(new ArrayList<>(cashDecription));
        }
    }

}
