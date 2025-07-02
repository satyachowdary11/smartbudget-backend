package com.satyasolutions.smartbudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmartBudgetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartBudgetAppApplication.class, args);
	}

}
