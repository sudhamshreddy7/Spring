package com.sudhamsh.getting_started_with_spring.DTO;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "new_york",value = "resident",havingValue = "true",matchIfMissing = false)
public class NewYorker {
    public NewYorker(){
        System.out.println("The user is from new york");
    }
}
