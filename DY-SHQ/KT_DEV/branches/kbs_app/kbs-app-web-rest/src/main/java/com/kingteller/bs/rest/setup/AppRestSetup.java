package com.kingteller.bs.rest.setup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.kingteller.bs.initialize.SystemInitialize;

@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:/appdao.xml")
public class AppRestSetup {

	@Value("${tomcatport:8090}")
	private int port; 
	
	@Bean  
	public EmbeddedServletContainerFactory servletContainer(){  
		return new TomcatEmbeddedServletContainerFactory(this.port);  
	}  
	
    public static void main(String[] args) {
    	SpringApplication springApplication = new SpringApplication(AppRestSetup.class);
    	springApplication.addListeners(new SystemInitialize());
        SpringApplication.run(AppRestSetup.class, args);
    }
}
