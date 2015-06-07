package org.kbs.app.web.security.sample.config;
//import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages={"org.kbs.app.web.security.sample.service.impl"})
@PropertySource("classpath:config.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"org.kbs.app.web.security.sample.repository"})
public class AppConfig{
    @Resource
    private Environment env;
    
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("c3p0.driverClass"));
        dataSource.setUrl(env.getProperty("c3p0.jdbcUrl"));
        dataSource.setUsername(env.getProperty("c3p0.user"));
        dataSource.setPassword(env.getProperty("c3p0.password"));
        return dataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        HibernateJpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        Properties jpaProperties=new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");//validate,create,create-drop
        LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("org.kbs.app.web.security.sample.domain");
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setJpaProperties(jpaProperties);
        return emf;
    }
    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
