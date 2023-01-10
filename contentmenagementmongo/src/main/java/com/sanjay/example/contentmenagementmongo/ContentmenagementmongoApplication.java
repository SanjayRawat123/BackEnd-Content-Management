package com.sanjay.example.contentmenagementmongo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication(exclude={JacksonAutoConfiguration.class, JmxAutoConfiguration.class})
@EnableFeignClients
public class ContentmenagementmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentmenagementmongoApplication.class, args);
	}





}
