package com.storeease.storeease_backend.model;

import java.time.LocalDateTime;

public class Notification {

    private Long notificationId;
    private User user;
    private String message;
    private LocalDateTime createdAt;
    private Status status = Status.UNREAD;

    // Enum for status
    public enum Status {
        UNREAD, READ
    }

    // Constructors
    public Notification() {}

    public Notification(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public Notification(Long notificationId, User user, String message, LocalDateTime createdAt, Status status) {
        this.notificationId = notificationId;
        this.user = user;
        this.message = message;
        this.createdAt = createdAt;
        this.status = status;
    }

    // Getters and Setters
    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification)) return false;
        Notification that = (Notification) o;
        return notificationId != null && notificationId.equals(that.notificationId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // toString
    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", user=" + user +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                ", status=" + status +
                '}';
    }
}
