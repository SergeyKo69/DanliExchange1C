package com.kogut.danliexchange1c.webservices.document;

import com.kogut.danliexchange1c.dto.document.invoice.InvoiceDTO;
import com.kogut.danliexchange1c.dto.services.HealthCheck;
import com.kogut.danliexchange1c.services.exchange.document.ExchangeInvoice;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author S.Kogut on 26.07.2021
 */

@RestController
@NoArgsConstructor
@RequestMapping("/api/v1")
public class InvoiceController {

    private IExchange<InvoiceDTO> exchangeService;

    @Autowired
    public InvoiceController(IExchange<InvoiceDTO> exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping(value = "/getStatus", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Health> getStatus() {
        return new ResponseEntity<>(new HealthCheck().health(), HttpStatus.OK);
    }

    @PostMapping(value = "/invoice", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> invoice(@RequestBody InvoiceDTO invoice) {
        try {
            exchangeService.exchange(invoice);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
