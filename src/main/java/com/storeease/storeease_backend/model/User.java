package com.storeease.storeease_backend.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;


    @Entity
    @Table(name = "users")

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

        public User(){}

        public User(Long user_id, String name, String email, String password, String role) {
            this.user_id = user_id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.role = role;
            this.created_at = LocalDateTime.now();
        }

        public Long getUser_id() {
            return user_id;
        }
        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getRole() {
            return role;
        }
        public void setRole(String role) {
            this.role = role;
        }
        public LocalDateTime getCreated_at() {
            return created_at;
        }
        public void setCreated_at(LocalDateTime created_at) {
            this.created_at = created_at;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return user_id != null && user_id.equals(user.user_id);
        }

        @Override
        public int hashCode() {
            return getClass().hashCode();
        }

        // toString() for debugging/logging
        @Override
        public String toString() {
            return "User{" +
                    "user_id=" + user_id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", role='" + role + '\'' +
                    ", created_at=" + created_at +
                    '}';
        }

    }




