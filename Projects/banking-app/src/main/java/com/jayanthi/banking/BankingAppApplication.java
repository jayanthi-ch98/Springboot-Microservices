package com.jayanthi.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingAppApplication {

//	@Bean
//	public ModelMapper modelMapper(){
//		return new ModelMapper();
//	}

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}

}
