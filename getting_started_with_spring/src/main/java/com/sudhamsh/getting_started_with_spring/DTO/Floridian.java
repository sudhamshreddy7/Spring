package com.sudhamsh.getting_started_with_spring.DTO;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "florida",value="resident",havingValue = "true",matchIfMissing = false)
public class Floridian {
    public Floridian(){
        System.out.println("The user from florida");
    }
}
