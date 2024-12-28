package com.sudhamsh.getting_started_with_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.module.Configuration;

@SpringBootApplication

public class GettingStartedWithSpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GettingStartedWithSpringApplication.class, args);
		// use this below line to test the lifecycle of the bean
		//		context.close();
	}

}
