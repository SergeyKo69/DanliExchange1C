package com.kogut.danliexchange1c.mapper.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.dto.document.invoice.InvoiceProductsTabDTO;
import com.kogut.danliexchange1c.dto.document.invoice.InvoiceServicesTabDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDB;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceEntity;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceProductsTabEntity;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceServicesTabEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author S.Kogut on 23.07.2021
 */

@Component
public class InvoiceMapper extends AbstractMapper<InvoiceEntity, InvoiceDTO> {

    private final ModelMapper mapper;

    @Autowired
    public InvoiceMapper(ModelMapper mapper) {
        super(InvoiceEntity.class, InvoiceDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(InvoiceDTO.class, InvoiceEntity.class)
                .addMappings(m -> m.skip(InvoiceEntity :: setId))
                .addMappings(m -> m.skip(InvoiceEntity :: setClientDB));
    }

    @Override
    public void mapSpecificFields(InvoiceEntity source, InvoiceDTO destination) {
        super.mapSpecificFields(source, destination);
        Set<InvoiceProductsTabDTO> products = new HashSet<>();
        Set<InvoiceServicesTabDTO> services = new HashSet<>();
        source.getProducts().parallelStream().forEach(product -> products.add(mapper.map(product, InvoiceProductsTabDTO.class)));
        source.getServices().parallelStream().forEach(service -> services.add(mapper.map(service, InvoiceServicesTabDTO.class)));
        destination.setProducts(new ArrayList<>(products));
        destination.setServices(new ArrayList<>(services));
    }

    @Override
    public void mapSpecificFields(InvoiceDTO source, InvoiceEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDB.valueOf(source.getClientDB()));
        Set<InvoiceProductsTabEntity> products = new HashSet<>();
        Set<InvoiceServicesTabEntity> services = new HashSet<>();
        source.getProducts().parallelStream().forEach(product -> products.add(mapper.map(product, InvoiceProductsTabEntity.class)));
        source.getServices().parallelStream().forEach(service -> services.add(mapper.map(service, InvoiceServicesTabEntity.class)));
        destination.setProducts(new ArrayList<>(products));
        destination.setServices(new ArrayList<>(services));
    }
}
