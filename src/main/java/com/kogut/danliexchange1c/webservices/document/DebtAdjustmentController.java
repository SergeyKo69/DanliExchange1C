package com.kogut.danliexchange1c.webservices.document;

import com.kogut.danliexchange1c.dto.document.debtadjustment.DebtAdjustmentDTO;
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
 * @author S.Kogut on 02.09.2021
 */

@RestController
@NoArgsConstructor
@RequestMapping("/api/v1")
public class DebtAdjustmentController {

    private IExchange<DebtAdjustmentDTO> exchangeService;

    @Autowired
    public DebtAdjustmentController(IExchange<DebtAdjustmentDTO> exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping(value = "/debtAdjustment", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> bankStatement(@RequestBody DebtAdjustmentDTO debtAdjustmentDTO) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> exchangeService.exchange(debtAdjustmentDTO));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
