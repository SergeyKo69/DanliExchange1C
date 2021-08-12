package com.kogut.danliexchange1c.model.document.bankstatement;

import com.kogut.danliexchange1c.model.document.common.AbstractCommonDocEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author S.Kogut on 12.08.2021
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "bank_statement")
public class BankStatementEntity extends AbstractCommonDocEntity {

    @Column(name = "view_operation")
    private String viewOperation = "";

    @Column(name = "agreement_id", length = 36)
    private String agreementId = "";

    @Column(name = "base_doc_id")
    private String baseDocId = "";

    @Column(name = "base_doc_view")
    private String baseDocView = "";

    @Column(name = "base_doc_view_operation")
    private String baseDocViewOperation = "";

    @Column(name = "client_id", length = 36)
    private String clientId = "";

    @Column(name = "number_in")
    private String numberIn = "";

    @Column(name = "date_in")
    private LocalDate dateIn;

    @Column(name = "paid")
    private Boolean paid;

    @Column(name = "date_paid")
    private LocalDate datePaid;

    @Column(name = "bill_id_client", length = 36)
    private String billIdClient;

    @Column(name = "bill_id_organisation", length = 36)
    private String billIdOrganisation;

    @Column(name = "purpose_of_payment")
    private String purposeOfPayment;

    @Column(name = "amount_doc")
    private BigDecimal amountDoc = BigDecimal.ZERO;

    @Column(name = "number_check")
    private String numberCheck = "";

    @Column(name = "article_id", length = 36)
    private String articleId = "";

    @Column(name = "currency_id")
    private String currencyId = "";

    @Embedded
    private BankStatementBaseDocEntity baseDoc;

    @ElementCollection
    @CollectionTable(name = "bank_statement_decription_tab", joinColumns = @JoinColumn(name = "bank_statement_id"))
    private List<BankStatementDecriptionTabEntity> cashDecription;

}
