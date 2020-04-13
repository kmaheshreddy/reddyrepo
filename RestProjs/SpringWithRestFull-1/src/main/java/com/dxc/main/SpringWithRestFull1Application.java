package com.dxc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dxc.controllers")
public class SpringWithRestFull1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithRestFull1Application.class, args);
	}

}
