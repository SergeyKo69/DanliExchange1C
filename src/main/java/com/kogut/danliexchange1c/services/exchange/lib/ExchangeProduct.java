package com.kogut.danliexchange1c.services.exchange.lib;

import com.kogut.danliexchange1c.dto.lib.product.ProductDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.lib.interfaces.IProductService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class ExchangeProduct implements IExchange<ProductDTO> {

    private final ISender<ProductDTO> sender;
    private final IProductService productService;

    @Autowired
    public ExchangeProduct(ISender<ProductDTO> sender, IProductService productService) {
        this.sender = sender;
        this.productService = productService;
    }

    @Override
    public void exchange(ProductDTO productDTO) {
        productService.deleteByExternalId(productDTO.getExternalId());
        HttpStatus status = sender.send(productDTO);
        if (status != HttpStatus.CREATED) {
            // Save database.
            productService.saveDTO(productDTO);
        }
    }
}
