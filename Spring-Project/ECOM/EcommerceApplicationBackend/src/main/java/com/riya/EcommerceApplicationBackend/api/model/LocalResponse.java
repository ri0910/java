package com.riya.EcommerceApplicationBackend.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LocalResponse {


    @NotBlank
    @NotNull
    private String jwt;

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
