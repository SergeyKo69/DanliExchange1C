package com.kogut.danliexchange1c.webservices.lib;

import com.kogut.danliexchange1c.dto.lib.gtd.GtdDTO;
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
public class GtdController {

    private IExchange<GtdDTO> exchangeService;

    @Autowired
    public GtdController(IExchange<GtdDTO> exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping(value = "/gtd", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> gtd(@RequestBody GtdDTO gtdDTO) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> exchangeService.exchange(gtdDTO));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
