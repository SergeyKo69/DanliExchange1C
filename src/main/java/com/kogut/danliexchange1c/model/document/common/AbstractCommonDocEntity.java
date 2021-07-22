package com.kogut.danliexchange1c.model.document.common;

import lombok.*;
import org.intellij.lang.annotations.Identifier;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractCommonDocEntity {

    @Id
    @Identifier
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "externalId")
    private String externalId = "";

    @Column(name = "dateDoc")
    private LocalDateTime dateDoc;

    @Column(name = "comment", columnDefinition="longtext")
    private String comment = "";

}
