package com.kogut.danliexchange1c.model.document.receiptcashorder;

import com.kogut.danliexchange1c.model.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author S.Kogut on 11.08.2021
 */

@Getter
@Setter
@Embeddable
public class ReceiptCashBaseDocEntity extends AbstractEntity {

    @Column(name = "id_base_doc", length = 36)
    private String idBaseDoc = "";

    @Column(name = "number_base_doc")
    private String numberBaseDoc = "";

    @Column(name = "date_base_doc")
    private LocalDateTime dateBaseDoc;

    @Column(name = "deleted_base_doc")
    private Boolean deletedBaseDoc;

    @Column(name = "amount_vat_doc")
    private BigDecimal amountVatDoc = BigDecimal.ZERO;

    @Column(name = "project_id_base_doc", length = 36)
    private String projectIdBaseDoc = "";

    @Column(name = "client_id_base_doc", length = 36)
    private String clientIdBaseDoc = "";

    @Column(name = "agreement_base_doc__id", length = 36)
    private String agreementBaseDocId = "";

    @Column(name = "comment_base_doc")
    private String commentBaseDoc = "";

}
