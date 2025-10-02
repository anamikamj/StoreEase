package com.storeease.storeease_backend.model;

import java.math.BigDecimal;

public class Item {
    private Long itemId;
    private String name;
    private String type;
    private BigDecimal price;
    private Integer quantity;
    private Integer threshold;

    public Item() {
    }

    public Item(String name, String type, BigDecimal price, Integer quantity, Integer threshold) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.threshold = threshold;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getThreshold() {
        return this.threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    @Override
    public String toString() {
        return "Item{itemId=" + this.itemId +
                ", name='" + this.name + '\'' +
                ", type='" + this.type + '\'' +
                ", price=" + this.price +
                ", quantity=" + this.quantity +
                ", threshold=" + this.threshold + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return this.itemId != null && this.itemId.equals(item.itemId);
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
