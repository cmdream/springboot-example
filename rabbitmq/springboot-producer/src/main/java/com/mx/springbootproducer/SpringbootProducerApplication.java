package com.mx.springbootproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootProducerApplication.class, args);
	}

}

