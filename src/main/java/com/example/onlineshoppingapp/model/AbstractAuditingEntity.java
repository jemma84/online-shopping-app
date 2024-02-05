package com.example.onlineshoppingapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractAuditingEntity {
    /*@Id
    @GeneratedValue
    private Long id;*/
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Instant createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Instant lastModifiedDate;
}
