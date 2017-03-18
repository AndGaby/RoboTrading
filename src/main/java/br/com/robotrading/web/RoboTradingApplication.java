package br.com.robotrading.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class RoboTradingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoboTradingApplication.class, args);
	}
}
