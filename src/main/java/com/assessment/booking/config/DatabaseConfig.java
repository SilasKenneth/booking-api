package com.assessment.booking.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Autowired
    private DataSource dataSource;
    @Bean
    public DataSource dataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        String[] parts = dbUrl.split("@");
        String[] parts2 = parts[0].split("//");
        String[] usernamePassword = parts2[1].split(":");
        String username = usernamePassword[0];
        String password = usernamePassword[1];
        String realUrl = "jdbc:postgresql://"+parts[1];
        hikariConfig.setJdbcUrl(realUrl);
//        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        return new HikariDataSource(hikariConfig);
    }
}
