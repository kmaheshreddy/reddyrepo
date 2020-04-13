package com.dxc.intializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.dxc.configs.MVCConfig;
import com.dxc.configs.RootConfig;

public class SpringBootStraper extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
		
		return new Class[] {RootConfig.class};
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		
		return new Class[] {MVCConfig.class};
	}

	@Override
	public String[] getServletMappings() {
	
		return new String[] {"/"};
	}

}
