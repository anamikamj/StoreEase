package com.storeease.storeease_backend.model;

import java.time.LocalDateTime;

public class Order {

    private Long orderId;
    private User user;
    private LocalDateTime orderDate;
    private Status status = Status.PENDING;

    // Enum for status
    public enum Status {
        PENDING, COMPLETED, CANCELLED
    }

    // Constructors
    public Order() {}

    public Order(User user, LocalDateTime orderDate, Status status) {
        this.user = user;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
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
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderId != null && orderId.equals(order.orderId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // toString
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }
}
