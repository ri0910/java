package com.riya.EcommerceApplicationBackend.model;


import io.micrometer.core.annotation.TimedSet;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "verification_token")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Lob
    @Column(name = "token", nullable = false, unique = true)
    private String token;


    @Column(name = "created_timestamp", nullable = false)
    private Timestamp createdTimestamp;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private LocalUser user;

}
