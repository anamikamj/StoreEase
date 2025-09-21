package com.storeease.storeease_backend.controller;

import com.storeease.storeease_backend.model.Item;
import com.storeease.storeease_backend.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    // Get all items
    @GetMapping
    public List<Item> getAllItems() {
        return service.getAllItems();
    }

    // Update threshold
    @PatchMapping("/{id}/threshold")
    public Item updateThreshold(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        return service.updateThreshold(id, body.get("threshold"));
    }

    // Update stock
    @PatchMapping("/{id}/stock")
    public Item updateStock(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        return service.updateStock(id, body.get("stockQuantity"));
    }

    // Get low-stock items
    @GetMapping("/alerts/low-stock")
    public List<Item> getLowStockItems() {
        return service.getLowStockItems();
    }
}

