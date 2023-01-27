package com.example.config;

import com.example.datasources.FakeDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@EnableConfigurationProperties(FakeDataSource.class)
@PropertySource("classpath:datasource.properties")
@Configuration
public class DataSourceConfiguration {
    @Bean
    FakeDataSource fakeDataSource(FakeDataSource fakeDataSource) {
        return new FakeDataSource(fakeDataSource.getUsername(), fakeDataSource.getPassword(), fakeDataSource.getJdbcUrl());
    }
}
