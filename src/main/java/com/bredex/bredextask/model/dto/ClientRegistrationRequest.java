package com.bredex.bredextask.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientRegistrationRequest {

    @NotNull
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name;

    @NotNull
    @Email
    private String email;

    public ClientRegistrationRequest() {
    }

    public ClientRegistrationRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}

