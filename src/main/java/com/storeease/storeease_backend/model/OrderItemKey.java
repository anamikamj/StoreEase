package com.storeease.storeease_backend.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Embeddable
@Data
public class OrderItemKey implements Serializable {
    private Long order_id;
    private Long item_id;
}
