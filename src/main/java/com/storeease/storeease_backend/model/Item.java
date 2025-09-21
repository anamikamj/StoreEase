package com.storeease.storeease_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long item_id;

    private String name;
    private String type;
    private Double price;
    private Integer quantity;
    private Integer threshold;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    public Item() {}

    public Item(String name, String type, Double price, Integer quantity, Integer threshold, Integer stockQuantity) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.threshold = threshold;
        this.stockQuantity = stockQuantity;
    }

    // Getters & Setters
    public Long getItem_id() { return item_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Integer getThreshold() { return threshold; }
    public void setThreshold(Integer threshold) { this.threshold = threshold; }
    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }
}
