package com.kogut.danliexchange1c.model.document.common;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
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

    @CreationTimestamp
    private LocalDateTime dateTime;

    @Column(name = "externalId")
    private String externalId = "";

    @Column(name = "number", length = 11)
    private String numberDoc = "";

    @Column(name = "dateDoc")
    private LocalDateTime dateDoc;

    @Column(name = "record")
    private Boolean record;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "comment", columnDefinition="longtext")
    private String comment = "";

}
