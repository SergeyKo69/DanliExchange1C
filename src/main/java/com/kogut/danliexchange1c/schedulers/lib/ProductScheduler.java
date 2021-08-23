package com.kogut.danliexchange1c.schedulers.lib;

import com.kogut.danliexchange1c.dto.lib.product.ProductDTO;
import com.kogut.danliexchange1c.mapper.abstracted.AbstractMapper;
import com.kogut.danliexchange1c.model.lib.product.ProductEntity;
import com.kogut.danliexchange1c.schedulers.AbstractLibScheduler;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IBaseLibService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 23.08.2021
 */

@Component
public class ProductScheduler extends AbstractLibScheduler<ProductDTO, ProductEntity> {

    @Autowired
    public ProductScheduler(IExchange<ProductDTO> exchangeService,
                            IBaseLibService<ProductEntity, ProductDTO> dbService,
                            AbstractMapper<ProductEntity, ProductDTO> mapper) {
        super(exchangeService, dbService, mapper);
    }

}
