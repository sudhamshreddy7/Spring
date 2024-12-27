package com.sudhamsh.getting_started_with_spring.DTO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public User createUserBean(){
        User u = new User();
        u.setEmail("default@gmail.com");
        u.setName("defaultName");
        return u;
    }
}
