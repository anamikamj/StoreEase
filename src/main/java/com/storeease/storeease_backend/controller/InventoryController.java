package com.storeease.storeease_backend.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storeease.storeease_backend.dao.InventoryDAO;
import com.storeease.storeease_backend.model.Item;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryDAO inventoryDAO = new InventoryDAO();

    // ---------- Existing endpoints ---------- //

    @GetMapping("/")
    public List<Item> getAllItems() throws SQLException {
        return inventoryDAO.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) throws SQLException {
        return inventoryDAO.getItem(id);
    }

    @PostMapping("/")
    public String addItem(@RequestBody Item item) throws SQLException {
        inventoryDAO.addItem(item);
        return "Item added";
    }

    @PutMapping("/{id}")
    public String updateItem(@PathVariable Long id, @RequestBody Item item) throws SQLException {
        item.setItemId(id);
        inventoryDAO.updateItem(item);
        return "Item updated with ID: " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) throws SQLException {
        inventoryDAO.deleteItem(id);
        return "Item deleted with ID: " + id;
    }

    @GetMapping("/low-stock")
    public List<Item> getLowStockItems() throws SQLException {
        return inventoryDAO.getLowStockItems();
    }

    @GetMapping("/type/{type}")
    public List<Item> getItemsByType(@PathVariable String type) throws SQLException {
        return inventoryDAO.getItemsByType(type);
    }

    

    // ---------- NEW PATCH endpoints ---------- //

@PatchMapping("/{id}/threshold")
public ResponseEntity<String> updateThreshold(@PathVariable Long id,
                                              @RequestParam("threshold") Integer threshold) {
    try {
        boolean success = inventoryDAO.updateThreshold(id, threshold);
        if (success) {
            return ResponseEntity.ok("✅ Threshold updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ Item not found or update failed");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("⚠️ Database error while updating threshold");
    }
}

@PatchMapping("/{id}/stock")
public ResponseEntity<String> updateStock(@PathVariable Long id,
                                          @RequestParam("quantity") Integer quantity) {
    try {
        boolean success = inventoryDAO.updateStock(id, quantity);
        if (success) {
            return ResponseEntity.ok("✅ Stock updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ Item not found or update failed");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("⚠️ Database error while updating stock");
    }
}
// ---------- NEW: Search items by name or type ----------
    @GetMapping("/search")
    public ResponseEntity<List<Item>> searchItems(@RequestParam(value = "name", required = false) String name,
                                                  @RequestParam(value = "type", required = false) String type) {
        try {
            List<Item> results = inventoryDAO.searchItems(name, type);
            if (results.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(results);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ---------- NEW: Filter items by price range & availability ----------
    @GetMapping("/filter")
    public ResponseEntity<List<Item>> filterItems(@RequestParam(value = "minPrice", required = false) Double minPrice,
                                                  @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                                                  @RequestParam(value = "availableOnly", defaultValue = "false") boolean availableOnly) {
        try {
            List<Item> results = inventoryDAO.filterItems(minPrice, maxPrice, availableOnly);
            if (results.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(results);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
     }

}
