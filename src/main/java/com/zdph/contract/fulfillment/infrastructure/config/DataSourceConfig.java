package com.zdph.contract.fulfillment.infrastructure.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment env;

    @Autowired
    private DataSourceProperties properties;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(this.properties.getUrl());
        config.setUsername(this.properties.getUsername());
        config.setPassword(this.properties.getPassword());
        config.setDriverClassName(this.properties.getDriverClassName());
        config.setMaximumPoolSize(Integer.valueOf(this.env.getProperty("spring.datasource.hikari.maximum-pool-size")).intValue());
        config.setPoolName("job_thread_pool");
        config.setConnectionTestQuery("SELECT  1");
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
