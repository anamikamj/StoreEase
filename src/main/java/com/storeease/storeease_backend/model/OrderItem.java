package com.storeease.storeease_backend.model;


import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_items")

@EmbeddedId
public class OrderItem {

    private OrderItemKey id;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "item_id")
    private Item item;

    private Integer quantity;

    public OrderItem(){}

    public OrderItem(Order order, Item item, Integer quantity){
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }

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
                ", order=" + (order != null ? order.getOrder_id() : null) +
                ", item=" + (item != null ? item.getItem_id() : null) +
                ", quantity=" + quantity +
                '}';
    }
}
