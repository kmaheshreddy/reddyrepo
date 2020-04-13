package com.dxc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dxc.configs.MVCConfig;
import com.dxc.configs.RootConfig;


@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories("com.dxc.daos")
@EntityScan("com.dxc.bo")
@Import({RootConfig.class,MVCConfig.class})
@EnableZuulProxy
@EnableHystrix
public class SpringBootEurekaserverClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaserverClientApplication.class, args);
	}

}
