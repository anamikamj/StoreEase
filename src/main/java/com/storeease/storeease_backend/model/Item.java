package com.storeease.storeease_backend.model;


import jakarta.persistence.*;


@Entity
@Table(name = "items")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    private String name;
    private String type;
    private Double price;
    private Integer quantity;
    private Integer threshold;

    // Default constructor (needed by JPA)
    public Item() {}

    // Parameterized constructor (optional, for convenience)
    public Item(String name, String type, Double price, Integer quantity, Integer threshold) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.threshold = threshold;
    }
    //getters and setters

    public Long getItem_id() {
        return item_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getPrice() {
        return price;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
    public Integer getThreshold(){
        return threshold;
    }

    @Override
    public String toString() {
        return "Item{"+
                "item_id="+item_id+
                ", name="+name+
                ", type="+type+
                ", price="+price+
                ", quantity="+quantity+
                ", threshold="+threshold+"}";
    }

    // equals() and hashCode() - based on item_id

    //Used to check if two Item objects have same item id and they will be considered equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return item_id != null && item_id.equals(item.item_id);
    }
    //Used to avoid NULL ID issues
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
