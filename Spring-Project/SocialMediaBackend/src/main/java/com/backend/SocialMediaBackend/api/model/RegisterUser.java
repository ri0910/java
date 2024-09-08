package com.backend.SocialMediaBackend.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class RegisterUser {

    @Getter
    @NotNull
    private String email;

    @Getter
    @NotNull
    private String name;

    @Getter
    @NotNull
    private String password;

    @Getter
    private String profilePicture;

}
