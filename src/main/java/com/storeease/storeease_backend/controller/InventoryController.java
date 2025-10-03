package com.storeease.storeease_backend.controller;

import com.storeease.storeease_backend.dao.InventoryDAO;
import com.storeease.storeease_backend.model.Item;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryDAO inventoryDAO = new InventoryDAO();

    // GET all items
    @GetMapping("/")
    public List<Item> getAllItems() throws SQLException {
        return inventoryDAO.getAllItems();
    }

    // GET item by ID
    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) throws SQLException {
        return inventoryDAO.getItem(id);
    }

    // POST new item
    @PostMapping("/")
    public String addItem(@RequestBody Item item) throws SQLException {
        inventoryDAO.addItem(item);
        return "Item added";
    }

    // PUT update item
    @PutMapping("/{id}")
    public String updateItem(@PathVariable Long id, @RequestBody Item item) throws SQLException {
        item.setItemId(id);
        inventoryDAO.updateItem(item);
        return "Item updated with ID: " + id;
    }

    // DELETE item
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) throws SQLException {
        inventoryDAO.deleteItem(id);
        return "Item deleted with ID: " + id;
    }

    // GET low stock items
    @GetMapping("/low-stock")
    public List<Item> getLowStockItems() throws SQLException {
        return inventoryDAO.getLowStockItems();
    }

    // GET items by type
    @GetMapping("/type/{type}")
    public List<Item> getItemsByType(@PathVariable String type) throws SQLException {
        return inventoryDAO.getItemsByType(type);
    }

    // GET search items by name
    @GetMapping("/search")
    public List<Item> searchItemsByName(@RequestBody String name) throws SQLException {
        return inventoryDAO.searchItemsByName(name);
    }
}
