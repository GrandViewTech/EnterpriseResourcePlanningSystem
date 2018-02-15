package com.gvt.application.configuration;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@EnableAutoConfiguration(exclude =
	{ DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@SpringBootApplication(scanBasePackages =
	{ "com.gvt.application" })
@PropertySource(value = "file:properties/application.properties")
public class ApplicationContext
	{
		
		final public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException
			{
				PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
				return propertySourcesPlaceholderConfigurer;
			}
			
		public static void main(String[] args) throws Exception
			{
				SpringApplication.run(ApplicationContext.class, args);
			}
			
	}
