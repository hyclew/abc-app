package com.kingteller.bs.service.impl.setup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan
@EnableAutoConfiguration
@Configuration
@EnableAsync
@ImportResource("classpath:/appservice.xml")
public class AppServiceSetup {
	
	public static void main(String[] args) {
        SpringApplication.run(AppServiceSetup.class, args);
    }
}
