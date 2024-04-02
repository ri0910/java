package com.riya.EcommerceApplicationBackend.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginUserBody {


    @NotNull
    @NotBlank
    private String username;


    @NotNull
    @NotBlank
    private String password;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
