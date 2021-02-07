package com.glaucus.task.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * A configuration class used to load rest resources from a specific package.
*/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.glaucus.task")
public class AppConfiguration {

	public static SessionFactory sessionFactory;

	@Bean(name = "sessionFactory")
	public static SessionFactory buildSessionFactory() {

		if (sessionFactory == null) {
			synchronized (AppConfiguration.class) {
				if (sessionFactory == null) {

					org.hibernate.cfg.Configuration configObj = new org.hibernate.cfg.Configuration();
					configObj.configure("hibernate.cfg.xml");
					ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
							.applySettings(configObj.getProperties()).build();
					sessionFactory = configObj.buildSessionFactory(serviceRegistryObj);
				}
			}
		}
		return sessionFactory;
	}
}