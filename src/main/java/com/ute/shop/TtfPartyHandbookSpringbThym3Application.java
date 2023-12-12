package com.ute.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class TtfPartyHandbookSpringbThym3Application {

	public static void main(String[] args) {
		SpringApplication.run(TtfPartyHandbookSpringbThym3Application.class, args);
	}

}
