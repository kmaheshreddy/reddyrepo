package com.dxc.configs;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dxc.bo.EmployeeBO;
import com.dxc.daos.EmployeeDAO;
import com.dxc.daos.EmployeeDAOImpl;

@Configuration
@ComponentScan("com.dxc.daos")
@EnableTransactionManagement
public class EmployeePersistenceConfig {
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource dataSource = null;
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/reddy?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("Reddy@1996");
		return dataSource;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getFactory() {
		LocalSessionFactoryBuilder lsfb = null;
		Properties p = null;
		lsfb = new LocalSessionFactoryBuilder(getDataSource());
		p = new Properties();
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		p.setProperty("hibernate.show_sql", "true");
		p.setProperty("hibernate.format_sql", "true");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		lsfb.addAnnotatedClass(EmployeeBO.class);
		lsfb.addProperties(p);

		return lsfb.buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager() {
		HibernateTransactionManager htm = null;
		htm = new HibernateTransactionManager(getFactory());
		return htm;
	}
}
