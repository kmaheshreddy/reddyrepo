package com.dxc.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dxc.emp.configs.MVCConfig;
import com.dxc.emp.configs.RootConfig;
import com.dxc.emp.swagger.EanableSawaggerConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
/*
 * @EnableJpaRepositories("com.dxc.daos")
 * 
 * @EntityScan("com.dxc.bo")
 * 
 * @Import({RootConfig.class,MVCConfig.class,EanableSawaggerConfig.class})
 */
public class SpringWithRestfullRestFullWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithRestfullRestFullWebServicesApplication.class, args);
	}

}

