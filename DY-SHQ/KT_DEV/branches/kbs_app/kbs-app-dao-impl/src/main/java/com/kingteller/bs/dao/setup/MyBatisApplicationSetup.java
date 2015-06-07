package com.kingteller.bs.dao.setup;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan
@EnableAutoConfiguration
@Configuration
@EnableAsync
@ImportResource("classpath:/appdao.xml")
public class MyBatisApplicationSetup {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplicationSetup.class, args);
    }

}
