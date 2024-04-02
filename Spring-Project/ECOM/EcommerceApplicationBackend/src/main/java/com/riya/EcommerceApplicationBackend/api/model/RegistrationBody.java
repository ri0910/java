package com.riya.EcommerceApplicationBackend.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class RegistrationBody {

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @Email
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$")
    private String password;

    @NotNull
    @NotBlank
    private String firstName;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String lastName;
}
