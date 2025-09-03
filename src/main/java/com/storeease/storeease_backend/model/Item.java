package com.storeease.storeease_backend.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    private String name;
    private String type;
    private Double price;
    private Integer quantity;
    private Integer threshold;
}
