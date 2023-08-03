package com.mixamum.carallauto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarallautoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarallautoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
		};
	}


}
