package com.storeease.storeease_backend.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    private Double amount;
    private String payment_method;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime payment_date;

    public Payment() {}

    public Payment(Order order, Double amount, String payment_method, LocalDateTime payment_date) {
        this.order = order;
        this.amount = amount;
        this.payment_method = payment_method;
        this.payment_date = payment_date;
    }
    public Long getPayment_id() {
        return payment_id;
    }
    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getPayment_method() {
        return payment_method;
    }
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
    public LocalDateTime getPayment_date() {
        return payment_date;
    }
    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }
    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", order=" + order +
                ", amount=" + amount +
                ", payment_method='" + payment_method + '\'' +
                ", payment_date=" + payment_date +
                '}';
    }
}
