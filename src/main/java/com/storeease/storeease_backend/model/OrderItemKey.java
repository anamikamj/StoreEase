package com.storeease.storeease_backend.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable

public class OrderItemKey implements Serializable {
    private Long order_id;
    private Long item_id;

    public OrderItemKey() {}

    public OrderItemKey(Long order_id, Long item_id) {
        this.order_id = order_id;
        this.item_id = item_id;
    }
    public Long getOrder_id() {
        return order_id;
    }
    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
    public Long getItem_id() {
        return item_id;
    }
    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemKey that = (OrderItemKey) o;
        return Objects.equals(order_id, that.order_id) &&
                Objects.equals(item_id, that.item_id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(order_id, item_id);
    }
}
