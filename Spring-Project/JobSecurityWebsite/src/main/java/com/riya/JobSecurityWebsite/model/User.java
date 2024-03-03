package com.riya.JobSecurityWebsite.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @Transient
    @NotNull
    private String confirmPassword;

    @NotNull
    private String role;
}
