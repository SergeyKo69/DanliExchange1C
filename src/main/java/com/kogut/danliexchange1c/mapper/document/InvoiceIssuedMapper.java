package com.kogut.danliexchange1c.mapper.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.dto.document.invoice.InvoiceProductsTabDTO;
import com.kogut.danliexchange1c.dto.document.invoice.InvoiceServicesTabDTO;
import com.kogut.danliexchange1c.dto.document.invoiceissued.InvoiceIssuedDTO;
import com.kogut.danliexchange1c.dto.document.invoiceissued.InvoiceIssuedPrepaymentTabDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceEntity;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceProductsTabEntity;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceServicesTabEntity;
import com.kogut.danliexchange1c.model.document.invoiceissued.InvoiceIssuedEntity;
import com.kogut.danliexchange1c.model.document.invoiceissued.InvoiceIssuedPrepaymentTabEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class InvoiceIssuedMapper extends AbstractMapper<InvoiceIssuedEntity, InvoiceIssuedDTO> {

    private final ModelMapper mapper;

    @Autowired
    public InvoiceIssuedMapper(ModelMapper mapper) {
        super(InvoiceIssuedEntity.class, InvoiceIssuedDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(InvoiceIssuedDTO.class, InvoiceIssuedEntity.class)
                .addMappings(m -> m.skip(InvoiceIssuedEntity :: setId))
                .addMappings(m -> m.skip(InvoiceIssuedEntity :: setClientDB));
    }

    @Override
    public void mapSpecificFields(InvoiceIssuedEntity source, InvoiceIssuedDTO destination) {
        super.mapSpecificFields(source, destination);
        Set<InvoiceIssuedPrepaymentTabDTO> prepayments = new HashSet<>();
        source.getPrepayment().parallelStream().forEach(payment -> prepayments.add(mapper.map(payment, InvoiceIssuedPrepaymentTabDTO.class)));
        destination.setPrepayment(new ArrayList<>(prepayments));
    }

    @Override
    public void mapSpecificFields(InvoiceIssuedDTO source, InvoiceIssuedEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
        Set<InvoiceIssuedPrepaymentTabEntity> prepayments = new HashSet<>();
        Set<InvoiceServicesTabEntity> services = new HashSet<>();
        source.getPrepayment().parallelStream().forEach(payment -> prepayments.add(mapper.map(payment, InvoiceIssuedPrepaymentTabEntity.class)));
        destination.setPrepayment(new ArrayList<>(prepayments));
    }

}
