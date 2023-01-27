package com.example.config;

import com.example.datasources.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:datasource.properties")
@Configuration
public class DataSourceConfiguration {
    @Bean
    FakeDataSource fakeDataSource(@Value("${ds.username}") String username, @Value("${ds.password}") String password, @Value("${ds.jdbcUrl}") String jdbcUrl) {
        return new FakeDataSource(username, password, jdbcUrl);
    }
}
