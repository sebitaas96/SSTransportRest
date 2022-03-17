package com.rest.transport;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) 
public class SsTransportRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsTransportRestApplication.class, args);
	}

}
