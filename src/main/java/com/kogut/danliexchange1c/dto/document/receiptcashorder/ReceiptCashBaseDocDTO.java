package com.kogut.danliexchange1c.dto.document.receiptcashorder;

import com.kogut.danliexchange1c.dto.common.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author S.Kogut on 11.08.2021
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReceiptCashBaseDocDTO extends AbstractDTO {

    private String idBaseDoc = "";
    private String numberBaseDoc = "";
    private LocalDateTime dateBaseDoc;
    private Boolean deletedBaseDoc;
    private BigDecimal amountVatDoc = BigDecimal.ZERO;
    private String projectIdBaseDoc = "";
    private String clientIdBaseDoc = "";
    private String agreementBaseDocId = "";
    private String commentBaseDoc = "";

}
