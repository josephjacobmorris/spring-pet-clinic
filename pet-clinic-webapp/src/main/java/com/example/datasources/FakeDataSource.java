package com.example.datasources;

public class FakeDataSource {
    private final String username;

    private final String password;

    private final String jdbcUrl;

    public FakeDataSource(String username, String password, String jdbcUrl) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }
}
