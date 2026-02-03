package com.pramodvaddiraju.userhub.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {

    @NotBlank(message = "Name must be blank")
    private String name;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Use Valid email")
    private String email;


    public UserRequestDTO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
