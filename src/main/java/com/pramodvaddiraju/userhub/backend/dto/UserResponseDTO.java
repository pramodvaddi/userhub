package com.pramodvaddiraju.userhub.backend.dto;

public class UserResponseDTO {

    private String name;
    private String email;

    public UserResponseDTO(){

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
