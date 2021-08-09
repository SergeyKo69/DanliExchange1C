package com.kogut.danliexchange1c.webservices.lib;

import com.kogut.danliexchange1c.dto.lib.deliveryaddress.DeliveryAddressDTO;
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
 * @author S.Kogut on 09.08.2021
 */

@RestController
@NoArgsConstructor
@RequestMapping("/api/v1")
public class DeliveryAddressController {

    private IExchange<DeliveryAddressDTO> exchangeService;

    @Autowired
    public DeliveryAddressController(IExchange<DeliveryAddressDTO> exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping(value = "deliveryAddress", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deliveryAddress(@RequestBody DeliveryAddressDTO deliveryAddress) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> exchangeService.exchange(deliveryAddress));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
