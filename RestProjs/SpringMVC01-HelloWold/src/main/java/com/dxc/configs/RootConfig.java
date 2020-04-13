package com.dxc.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {EmployeePersistenceConfig.class,EmployeeServiceConfig.class})
public class RootConfig {

}
