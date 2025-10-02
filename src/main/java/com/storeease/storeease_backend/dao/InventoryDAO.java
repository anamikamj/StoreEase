package com.storeease.storeease_backend.dao;


import com.storeease.storeease_backend.model.Item;
import com.storeease.storeease_backend.util.DBUtil;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {

    // Add a new item
    public void addItem(Item item) throws SQLException {
        String sql = "INSERT INTO items (name, type, price, quantity, threshold) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getType());
            ps.setBigDecimal(3, item.getPrice());
            ps.setInt(4, item.getQuantity());
            ps.setInt(5, item.getThreshold());
            ps.executeUpdate();
        }
    }

    // Get item by ID
    public Item getItem(Long id) throws SQLException {
        String sql = "SELECT * FROM items WHERE item_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Item item = new Item(
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        rs.getInt("threshold")
                );
                item.setItemId(rs.getLong("item_id"));
                return item;
            }
        }
        return null;
    }

    // Get all items
    public List<Item> getAllItems() throws SQLException {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items";
        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Item item = new Item(
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        rs.getInt("threshold")
                );
                item.setItemId(rs.getLong("item_id"));
                items.add(item);
            }
        }
        return items;
    }

    // Update item
    public void updateItem(Item item) throws SQLException {
        String sql = "UPDATE items SET name=?, type=?, price=?, quantity=?, threshold=? WHERE item_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getType());
            ps.setBigDecimal(3, item.getPrice());
            ps.setInt(4, item.getQuantity());
            ps.setInt(5, item.getThreshold());
            ps.setLong(6, item.getItemId());
            ps.executeUpdate();
        }
    }

    // Delete item
    public void deleteItem(Long id) throws SQLException {
        String sql = "DELETE FROM items WHERE item_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    // Update item quantity (useful for orders)
    public void updateQuantity(Long itemId, Integer quantity) throws SQLException {
        String sql = "UPDATE items SET quantity=? WHERE item_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setLong(2, itemId);
            ps.executeUpdate();
        }
    }

    // Get low stock items (quantity <= threshold)
    public List<Item> getLowStockItems() throws SQLException {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE quantity <= threshold";
        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Item item = new Item(
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        rs.getInt("threshold")
                );
                item.setItemId(rs.getLong("item_id"));
                items.add(item);
            }
        }
        return items;
    }

    // Search items by name
    public List<Item> searchItemsByName(String name) throws SQLException {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE name LIKE ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        rs.getInt("threshold")
                );
                item.setItemId(rs.getLong("item_id"));
                items.add(item);
            }
        }
        return items;
    }

    // Get items by type
    public List<Item> getItemsByType(String type) throws SQLException {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE type=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getBigDecimal("price"),
                        rs.getInt("quantity"),
                        rs.getInt("threshold")
                );
                item.setItemId(rs.getLong("item_id"));
                items.add(item);
            }
        }
        return items;
    }
}