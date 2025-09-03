package com.storeease.storeease_backend.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

    @Entity
    @Table(name = "users")
    @Data
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long user_id;

        private String name;
        private String email;
        private String password;
        private String role;

        @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime created_at;
    }




