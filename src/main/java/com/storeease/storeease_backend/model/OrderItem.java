package com.storeease.storeease_backend.model;

import java.util.Objects;

public class OrderItem {

    private OrderItemKey id;
    private Order order;
    private Item item;
    private Integer quantity;

    // Constructors
    public OrderItem() {}

    public OrderItem(Order order, Item item, Integer quantity) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
        this.id = new OrderItemKey(order.getOrderId(), item.getItemId());
    }

    // Getters and Setters
    public OrderItemKey getId() {
        return id;
    }

    public void setId(OrderItemKey id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem that = (OrderItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + (order != null ? order.getOrderId() : null) +
                ", item=" + (item != null ? item.getItemId() : null) +
                ", quantity=" + quantity +
                '}';
    }
}
