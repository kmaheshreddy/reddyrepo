package com.dxc.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringBeansConfig {
	@Bean
	public RestTemplate getTemplate() {
		RestTemplate template=null;
		template=new RestTemplate();
		return template;
	}

}
