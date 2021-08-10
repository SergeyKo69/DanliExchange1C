package com.kogut.danliexchange1c.mapper.lib;

import com.kogut.danliexchange1c.dto.lib.product.ProductDTO;
import com.kogut.danliexchange1c.enumerations.general.ClientDBEnum;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.product.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class ProductMapper extends AbstractMapper<ProductEntity, ProductDTO> {

    private final ModelMapper mapper;

    @Autowired
    public ProductMapper(ModelMapper mapper) {
        super(ProductEntity.class, ProductDTO.class);
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(ProductDTO.class, ProductEntity.class)
                .addMappings(m -> m.skip(ProductEntity:: setId))
                .addMappings(m -> m.skip(ProductEntity::setClientDB));
    }

    @Override
    public void mapSpecificFields(ProductEntity source, ProductDTO destination) {
        super.mapSpecificFields(source, destination);
    }

    @Override
    public void mapSpecificFields(ProductDTO source, ProductEntity destination) {
        super.mapSpecificFields(source, destination);
        destination.setClientDB(ClientDBEnum.valueOf(source.getClientDB()));
    }

}
