package com.dxc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.dxc.configs.SpringBeansConfig;

@SpringBootApplication
@ComponentScan("com.dxc.controller")
@Import({SpringBeansConfig.class})
public class SpringWithRestfullRestTemplateApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringWithRestfullRestTemplateApplication.class, args);
	}
	

}
