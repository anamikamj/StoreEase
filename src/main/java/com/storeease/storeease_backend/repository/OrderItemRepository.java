package com.storeease.storeease_backend.repository;
import com.storeease.storeease_backend.model.OrderItem;
import com.storeease.storeease_backend.model.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemKey> { }
