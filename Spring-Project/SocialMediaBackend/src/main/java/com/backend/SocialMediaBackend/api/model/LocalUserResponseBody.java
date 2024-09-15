package com.backend.SocialMediaBackend.api.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalUserResponseBody {

    @NotNull
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String token;


}
