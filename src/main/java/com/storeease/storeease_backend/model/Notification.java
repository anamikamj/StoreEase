package com.storeease.storeease_backend.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notification_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    private String message;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;

    private String status;

    public Notification() {}

    public Notification(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public Notification(Long notification_id, User user, String message, LocalDateTime created_at, String status) {
        this.notification_id = notification_id;
        this.user = user;
        this.message = message;
        this.created_at = created_at;
        this.status = status;
    }
    public Long getNotification_id() {
        return notification_id;
    }
    public void setNotification_id(Long notification_id) {
        this.notification_id = notification_id;

    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getCreated_at() {
        return created_at;
    }
    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification)) return false;
        Notification that = (Notification) o;
        return notification_id != null && notification_id.equals(that.notification_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // toString()
    @Override
    public String toString() {
        return "Notification{" +
                "notification_id=" + notification_id +
                ", user=" + user +
                ", message='" + message + '\'' +
                ", created_at=" + created_at +
                ", status='" + status + '\'' +
                '}';
    }

}
