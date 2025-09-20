package com.storeease.storeease_backend.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;



    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime order_date;

    private String status;

    public Order(){}

    public Order(User user, LocalDateTime order_date, String status) {
        this.user = user;
        this.order_date = order_date;
        this.status = status;

    }

    //Getters and Setters
    public Long getOrder_id() {
        return order_id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LocalDateTime getOrder_date() {
        return order_date;
    }
    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
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
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return order_id != null && order_id.equals(order.order_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // toString()
    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user=" + user +
                ", order_date=" + order_date +
                ", status='" + status + '\'' +
                '}';
    }


}
