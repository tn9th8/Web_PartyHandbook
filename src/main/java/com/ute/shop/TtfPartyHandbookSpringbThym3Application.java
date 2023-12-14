package com.ute.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.ute.shop.config.StorageProperties;
import com.ute.shop.service.StorageService;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableConfigurationProperties(StorageProperties.class) //to upload file
public class TtfPartyHandbookSpringbThym3Application {

	public static void main(String[] args) {
		SpringApplication.run(TtfPartyHandbookSpringbThym3Application.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (argv ->{
			storageService.init();
		});
	}

}
