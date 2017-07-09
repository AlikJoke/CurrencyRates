package ru.project.currency.rates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan
@EnableScheduling
@EnableWebMvc
@EnableAutoConfiguration
public class CurrencyRatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyRatesApplication.class, args);
	}
}
