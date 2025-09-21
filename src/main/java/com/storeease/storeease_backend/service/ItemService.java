package com.storeease.storeease_backend.service;

import com.storeease.storeease_backend.model.Item;
import com.storeease.storeease_backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Item updateThreshold(Long id, Integer newThreshold) {
        Item item = repository.findById(id.intValue()).orElseThrow();
        item.setThreshold(newThreshold);
        return repository.save(item);
    }

    public Item updateStock(Long id, Integer newStock) {
        Item item = repository.findById(id.intValue()).orElseThrow();
        item.setStockQuantity(newStock);
        return repository.save(item);
    }

    public List<Item> getLowStockItems() {
        return repository.findAll().stream()
                .filter(i -> i.getStockQuantity() != null && i.getStockQuantity() < i.getThreshold())
                .toList();
    }
}

