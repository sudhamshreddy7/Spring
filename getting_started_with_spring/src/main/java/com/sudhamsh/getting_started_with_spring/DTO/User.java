package com.sudhamsh.getting_started_with_spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Name")
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

}
