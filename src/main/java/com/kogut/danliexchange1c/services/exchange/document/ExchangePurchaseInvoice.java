package com.kogut.danliexchange1c.services.exchange.document;

import com.kogut.danliexchange1c.dto.document.purchaseinvoice.PurchaseInvoiceDTO;
import com.kogut.danliexchange1c.senders.interfaces.ISender;
import com.kogut.danliexchange1c.services.db.document.interfaces.IPurchaseInvoiceService;
import com.kogut.danliexchange1c.services.exchange.interfaces.IExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author S.Kogut on 10.08.2021
 */

@Component
public class ExchangePurchaseInvoice implements IExchange<PurchaseInvoiceDTO> {

    private final ISender<PurchaseInvoiceDTO> sender;
    private final IPurchaseInvoiceService purchaseInvoiceService;

    @Autowired
    public ExchangePurchaseInvoice(ISender<PurchaseInvoiceDTO> sender, IPurchaseInvoiceService purchaseInvoiceService) {
        this.sender = sender;
        this.purchaseInvoiceService = purchaseInvoiceService;
    }

    @Override
    public void exchange(PurchaseInvoiceDTO purchaseInvoiceDTO) {
        purchaseInvoiceService.deleteByExternalId(purchaseInvoiceDTO.getExternalId());
        HttpStatus status = sender.send(purchaseInvoiceDTO);
        if (status != HttpStatus.CREATED) {
            // Save database.
            purchaseInvoiceService.saveDTO(purchaseInvoiceDTO);
        }
    }
}
