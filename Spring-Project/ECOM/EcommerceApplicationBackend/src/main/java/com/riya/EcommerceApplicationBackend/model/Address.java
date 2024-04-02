package com.riya.EcommerceApplicationBackend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "address")
@ToString(exclude = {"user"})
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "address_line_1", nullable = false, length = 512)
    private String addressLine1;

    @Column(name = "address_line_2", length = 512)
    private String addressLine2;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private LocalUser user;


}
