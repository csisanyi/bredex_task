package com.bredex.bredextask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class BredexTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(BredexTaskApplication.class, args);
	}

}
