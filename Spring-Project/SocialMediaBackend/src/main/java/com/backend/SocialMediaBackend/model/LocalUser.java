package com.backend.SocialMediaBackend.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "social_media_user")
public class LocalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "profilePicture", length = 1326552243)
    private String profilePicture;
}
