package com.kogut.danliexchange1c.webservices.document;

import com.kogut.danliexchange1c.dto.document.invoiceissued.InvoiceIssuedDTO;
import com.kogut.danliexchange1c.dto.document.purchaseinvoice.PurchaseInvoiceDTO;
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
public class PurchaseInvoiceController {

    private IExchange<PurchaseInvoiceDTO> exchangeService;

    @Autowired
    public PurchaseInvoiceController(IExchange<PurchaseInvoiceDTO> exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping(value = "/purchaseInvoice", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> purchaseInvoice(@RequestBody PurchaseInvoiceDTO purchaseInvoiceDTO) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> exchangeService.exchange(purchaseInvoiceDTO));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
