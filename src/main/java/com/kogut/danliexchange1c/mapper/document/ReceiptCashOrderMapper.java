package com.kogut.danliexchange1c.mapper.document;

import com.kogut.danliexchange1c.dto.document.receiptcashorder.ReceiptCashBaseDocDTO;
import com.kogut.danliexchange1c.dto.document.receiptcashorder.ReceiptCashOrderDTO;
import com.kogut.danliexchange1c.dto.document.receiptcashorder.ReceiptCashPaymentDecriptionTabDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.receiptcashorder.ReceiptCashBaseDocEntity;
import com.kogut.danliexchange1c.model.document.receiptcashorder.ReceiptCashOrderEntity;
import com.kogut.danliexchange1c.model.document.receiptcashorder.ReceiptCashPaymentDecriptionTabEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author S.Kogut on 11.08.2021
 */

@Component
public class ReceiptCashOrderMapper extends AbstractMapper<ReceiptCashOrderEntity, ReceiptCashOrderDTO> {

    private final ModelMapper mapper;

    @Autowired
    public ReceiptCashOrderMapper(ModelMapper mapper) {
        super(ReceiptCashOrderEntity.class, ReceiptCashOrderDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(ReceiptCashOrderDTO.class, ReceiptCashOrderEntity.class)
                .addMappings(m -> m.skip(ReceiptCashOrderEntity :: setId))
                .addMappings(m -> m.skip(ReceiptCashOrderEntity :: setClientDB));
    }

    @Override
    public void mapSpecificFields(ReceiptCashOrderEntity source, ReceiptCashOrderDTO destination) {
        super.mapSpecificFields(source, destination);
        source.setBaseDoc(mapper.map(destination.getBaseDoc(), ReceiptCashBaseDocEntity.class));
        Set<ReceiptCashPaymentDecriptionTabDTO> cashDecription = new HashSet<>();
        List<ReceiptCashPaymentDecriptionTabEntity> cashDecriptionE = source.getCashDecription();
        if (cashDecriptionE != null) {
            cashDecriptionE.forEach(cash -> {
                ReceiptCashPaymentDecriptionTabDTO cashDecriptionDTO =
                        mapper.map(cash, ReceiptCashPaymentDecriptionTabDTO.class);
                ReceiptCashBaseDocEntity baseDoc = cash.getDocR();
                if (baseDoc != null) {
                    cashDecriptionDTO.setDocR(mapper.map(baseDoc, ReceiptCashBaseDocDTO.class));
                }
                cashDecription.add(cashDecriptionDTO);
            });
            destination.setCashDecription(new ArrayList<>(cashDecription));
        }
    }

    @Override
    public void mapSpecificFields(ReceiptCashOrderDTO source, ReceiptCashOrderEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
        source.setBaseDoc(mapper.map(destination.getBaseDoc(), ReceiptCashBaseDocDTO.class));
        Set<ReceiptCashPaymentDecriptionTabEntity> cashDecription = new HashSet<>();
        List<ReceiptCashPaymentDecriptionTabDTO> cashDecriptionDTO = source.getCashDecription();
        if (cashDecriptionDTO != null) {
            cashDecriptionDTO.forEach(cash -> {
                ReceiptCashPaymentDecriptionTabEntity cashDecriptionE =
                        mapper.map(cash, ReceiptCashPaymentDecriptionTabEntity.class);
                ReceiptCashBaseDocDTO baseDoc = cash.getDocR();
                if (baseDoc != null) {
                    cashDecriptionE.setDocR(mapper.map(baseDoc, ReceiptCashBaseDocEntity.class));
                }
                cashDecription.add(cashDecriptionE);
            });
            destination.setCashDecription(new ArrayList<>(cashDecription));
        }
    }

}
