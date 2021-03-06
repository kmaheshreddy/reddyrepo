package com.dxc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dxc.configs.MVCConfig;
import com.dxc.configs.RootConfig;


@SpringBootApplication
@EnableJpaRepositories("com.dxc.daos")
@EntityScan("com.dxc.bo")
@Import({RootConfig.class,MVCConfig.class})
public class SpringWithRestfullRestFullWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithRestfullRestFullWebServicesApplication.class, args);
	}

}
