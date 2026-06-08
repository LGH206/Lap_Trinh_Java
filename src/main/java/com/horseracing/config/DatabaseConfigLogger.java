package com.horseracing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DatabaseConfigLogger implements CommandLineRunner {
//database
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DATABASE CONFIGURATION DIAGNOSTICS:");
        System.out.println("JDBC URL: " + dbUrl);
        System.out.println("DB Username: " + dbUsername);
    }
}
