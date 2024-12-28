package com.sudhamsh.getting_started_with_spring.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;

public class User {
    public String getName() {
        return name;
    }
    User(){
        System.out.println("New User is created");
    }
    @PostConstruct
    public void  userCreation(){
        System.out.println("This message is from PostConstruct");
    }
    @PreDestroy
    public void userDeletion(){
        System.out.println("This message is from PreDestroy");
    }
    @Autowired
    PaymentResponse paymentResponse;
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
