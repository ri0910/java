package com.riya.Ecomerce.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    @NotBlank(message = "Please enter your first name")
    private String firstname;

    @Column(name="last_name")
    @NotBlank(message = "Please enter your last name")
    private String lastname;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "contact_number")
    @NotBlank(message = "Please enter contact number")
    private String contactNumber;

    @Column(name = "password")
    @NotBlank(message = "Please enter a valid password")
    private String password;

    // confirm password transient field
    @Transient
    private String confirmPassword;

    @Column(name = "role")
    private String role;

    @Column(name="enabled")
    private boolean enabled= true;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;


}
