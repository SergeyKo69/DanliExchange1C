package com.kogut.danliexchange1c.model.lib.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.intellij.lang.annotations.Identifier;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author S.Kogut on 03.08.2021
 */

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class AbstractCommonLibEntity {

    @Id
    @Identifier
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @CreationTimestamp
    private LocalDateTime dateTime;

    @Column(name = "externalId", length = 36)
    private String externalId = "";

    @Column(name = "code", length = 11)
    private String code;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "parentId", length = 36)
    private String parentId;

    @Column(name = "ownerId", length = 36)
    private String ownerId;

    @Column(name = "deleted")
    private Boolean deleted;

}
