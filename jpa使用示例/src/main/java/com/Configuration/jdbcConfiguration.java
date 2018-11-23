package com.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class jdbcConfiguration {
    @Autowired
    private Environment env;
    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("url"));
        dataSource.setDriverClassName(env.getProperty("driverClass"));
        dataSource.setUsername(env.getProperty("username"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }
}
