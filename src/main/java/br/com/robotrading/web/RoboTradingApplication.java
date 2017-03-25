package br.com.robotrading.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EntityScan(basePackages={"br.com.robotrading.web.model"})
@EnableJpaRepositories(basePackages={"br.com.robotrading.web.dao"})
public class RoboTradingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoboTradingApplication.class, args);
	}
}
