package com.dxc.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.dxc.controller")
public class MVCconfig {
//hi mahesh
	@Bean
	public ViewResolver getResolver() {
		InternalResourceViewResolver vr = null;
		vr = new InternalResourceViewResolver();
		vr.setPrefix("WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}

}
