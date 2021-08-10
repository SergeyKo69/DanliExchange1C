package com.kogut.danliexchange1c.mapper.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.dto.document.invoice.InvoiceProductsTabDTO;
import com.kogut.danliexchange1c.dto.document.invoice.InvoiceServicesTabDTO;
import com.kogut.danliexchange1c.dto.document.purchaseinvoice.PurchaseInvoiceDTO;
import com.kogut.danliexchange1c.dto.document.purchaseinvoice.PurchaseInvoiceProductTabDTO;
import com.kogut.danliexchange1c.dto.document.purchaseinvoice.PurchaseinvoiceServicesTabDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceEntity;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceProductsTabEntity;
import com.kogut.danliexchange1c.model.document.invoice.InvoiceServicesTabEntity;
import com.kogut.danliexchange1c.model.document.purchaseinvoice.PurchaseInvoiceEntity;
import com.kogut.danliexchange1c.model.document.purchaseinvoice.PurchaseInvoiceProductsTabEntity;
import com.kogut.danliexchange1c.model.document.purchaseinvoice.PurchaseInvoiceServicesTabEntity;
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
public class PurchaseInvoiceMapper extends AbstractMapper<PurchaseInvoiceEntity, PurchaseInvoiceDTO> {

    private final ModelMapper mapper;

    @Autowired
    public PurchaseInvoiceMapper(ModelMapper mapper) {
        super(PurchaseInvoiceEntity.class, PurchaseInvoiceDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(PurchaseInvoiceDTO.class, PurchaseInvoiceEntity.class)
                .addMappings(m -> m.skip(PurchaseInvoiceEntity :: setId))
                .addMappings(m -> m.skip(PurchaseInvoiceEntity :: setClientDB));
    }

    @Override
    public void mapSpecificFields(PurchaseInvoiceEntity source, PurchaseInvoiceDTO destination) {
        super.mapSpecificFields(source, destination);
        Set<PurchaseInvoiceProductTabDTO> products = new HashSet<>();
        Set<PurchaseinvoiceServicesTabDTO> services = new HashSet<>();
        source.getProducts().parallelStream().forEach(product -> products.add(mapper.map(product, PurchaseInvoiceProductTabDTO.class)));
        source.getServices().parallelStream().forEach(service -> services.add(mapper.map(service, PurchaseinvoiceServicesTabDTO.class)));
        destination.setProducts(new ArrayList<>(products));
        destination.setServices(new ArrayList<>(services));
    }

    @Override
    public void mapSpecificFields(PurchaseInvoiceDTO source, PurchaseInvoiceEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
        Set<PurchaseInvoiceProductsTabEntity> products = new HashSet<>();
        Set<PurchaseInvoiceServicesTabEntity> services = new HashSet<>();
        source.getProducts().parallelStream().forEach(product -> products.add(mapper.map(product, PurchaseInvoiceProductsTabEntity.class)));
        source.getServices().parallelStream().forEach(service -> services.add(mapper.map(service, PurchaseInvoiceServicesTabEntity.class)));
        destination.setProducts(new ArrayList<>(products));
        destination.setServices(new ArrayList<>(services));
    }

}
