package com.kogut.danliexchange1c.webservices.document;

import com.kogut.danliexchange1c.dto.document.receiptcashorder.ReceiptCashOrderDTO;
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
 * @author S.Kogut on 11.08.2021
 */

@RestController
@NoArgsConstructor
@RequestMapping("/api/v1")
public class ReceiptCashOrderController {

    private IExchange<ReceiptCashOrderDTO> exchangeService;

    @Autowired
    public ReceiptCashOrderController(IExchange<ReceiptCashOrderDTO> exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping(value = "/receiptCashOrder", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> receiptCashOrder(@RequestBody ReceiptCashOrderDTO receiptCashOrderDTO) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> exchangeService.exchange(receiptCashOrderDTO));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
