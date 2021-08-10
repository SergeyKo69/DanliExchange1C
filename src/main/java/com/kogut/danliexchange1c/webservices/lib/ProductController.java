package com.kogut.danliexchange1c.webservices.lib;

import com.kogut.danliexchange1c.dto.lib.product.ProductDTO;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author S.Kogut on 10.08.2021
 */

@RestController
@NoArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private IExchange<ProductDTO> exchangeService;

    @Autowired
    public ProductController(IExchange<ProductDTO> exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping(value = "/product", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> product(@RequestBody ProductDTO productDTO) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> exchangeService.exchange(productDTO));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
