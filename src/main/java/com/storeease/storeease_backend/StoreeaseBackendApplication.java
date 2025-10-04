package com.storeease.storeease_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class StoreeaseBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreeaseBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner testDatabase(JdbcTemplate jdbcTemplate) {
        return args -> {
            try {
                Integer count = jdbcTemplate.queryForObject(
                        "SELECT COUNT(*) FROM store_timings",
                        Integer.class
                );
                System.out.println("✅ Database connected! store_timings rows = " + count);
            } catch (Exception e) {
                System.err.println("❌ Database connection failed: " + e.getMessage());
            }
        };
    }
}
