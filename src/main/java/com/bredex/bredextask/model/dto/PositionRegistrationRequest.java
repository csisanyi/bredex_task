package com.bredex.bredextask.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PositionRegistrationRequest {

    @NotBlank(message = "Position name is required")
    @Size(max = 50, message = "Position name cannot be longer than 50 characters")
    private String name;

    @NotBlank(message = "Geographical location is required")
    @Size(max = 50, message = "Geographical location cannot be longer than 50 characters")
    private String location;

    public PositionRegistrationRequest() {
    }

    public PositionRegistrationRequest(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

}
