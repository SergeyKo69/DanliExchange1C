package com.kogut.danliexchange1c.mapper.document;

import com.kogut.danliexchange1c.dto.document.invoicereceived.InvoiceReceivedDTO;
import com.kogut.danliexchange1c.dto.document.invoicereceived.InvoiceReceivedPrepaymentTabDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.invoicereceived.InvoiceReceivedEntity;
import com.kogut.danliexchange1c.model.document.invoicereceived.InvoiceReceivedPrepaymentTabEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

/**
 * @author S.Kogut on 11.08.2021
 */

@Component
public class InvoiceReceivedMapper extends AbstractMapper<InvoiceReceivedEntity, InvoiceReceivedDTO> {

    private final ModelMapper mapper;

    @Autowired
    public InvoiceReceivedMapper(ModelMapper mapper) {
        super(InvoiceReceivedEntity.class, InvoiceReceivedDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(InvoiceReceivedDTO.class, InvoiceReceivedEntity.class)
                .addMappings(m -> m.skip(InvoiceReceivedEntity :: setId))
                .addMappings(m -> m.skip(InvoiceReceivedEntity :: setClientDB));
    }

    @Override
    public void mapSpecificFields(InvoiceReceivedEntity source, InvoiceReceivedDTO destination) {
        super.mapSpecificFields(source, destination);
        destination.setPrepayment(source.getPrepayment()
                .parallelStream()
                .map(row -> mapper.map(row, InvoiceReceivedPrepaymentTabDTO.class))
                .collect(Collectors.toList())
        );
    }

    @Override
    public void mapSpecificFields(InvoiceReceivedDTO source, InvoiceReceivedEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
        destination.setPrepayment(
                source.getPrepayment()
                        .parallelStream()
                .map(row -> mapper.map(row, InvoiceReceivedPrepaymentTabEntity.class))
                .collect(Collectors.toList())
        );
    }

}
