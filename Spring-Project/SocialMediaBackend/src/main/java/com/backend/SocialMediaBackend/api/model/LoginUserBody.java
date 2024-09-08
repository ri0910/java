package com.backend.SocialMediaBackend.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class LoginUserBody {

    @Getter
    @NotNull
    private String email;

    @Getter
    @NotNull
    private String password;
}
