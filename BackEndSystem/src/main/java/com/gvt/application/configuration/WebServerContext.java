package com.gvt.application.configuration;

import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class WebServerContext implements WebApplicationInitializer
	{
		
		@Value("${server.port}")
		private Integer port = 8080;
		
		@Override
		public void onStartup(ServletContext servletContext) throws ServletException
			{
				WebApplicationContext context = getContext();
				servletContext.addListener(new ContextLoaderListener(context));
				DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
				ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", dispatcherServlet);
				dispatcher.setLoadOnStartup(1);
				dispatcher.addMapping("/");
			}
			
		private AnnotationConfigWebApplicationContext getContext()
			{
				AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
				context.setConfigLocation("com.gvt.application");
				return context;
			}
			
		@Bean
		public EmbeddedServletContainerFactory servletContainer()
			{
				TomcatEmbeddedServletContainerFactory embeddedServletContainerFactory = new TomcatEmbeddedServletContainerFactory();
				embeddedServletContainerFactory.setPort(port);
				embeddedServletContainerFactory.setSessionTimeout(10, TimeUnit.MINUTES);
				/// embeddedServletContainerFactory.setContextPath("/datawareHouse");
				return embeddedServletContainerFactory;
			}
			
	}