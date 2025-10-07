package com.storeease.storeease_backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.storeease.storeease_backend.model.Item;
import com.storeease.storeease_backend.util.DBUtil;

public class InventoryDAO {

    // ---------- Existing methods ---------- //

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

    public void deleteItem(Long id) throws SQLException {
        String sql = "DELETE FROM items WHERE item_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

  // ---------- New Methods for Threshold & Stock ---------- //

// Update threshold for an item
public boolean updateThreshold(Long itemId, Integer threshold) throws SQLException {
    String sql = "UPDATE items SET threshold=? WHERE item_id=?";
    try (Connection con = DBUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, threshold);
        ps.setLong(2, itemId);
        int updated = ps.executeUpdate();
        return updated > 0;
    }
}

// Update stock (quantity) & auto-check threshold
public boolean updateStock(Long itemId, Integer quantity) throws SQLException {
    String sql = "UPDATE items SET quantity=? WHERE item_id=?";
    try (Connection con = DBUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, quantity);
        ps.setLong(2, itemId);
        int updated = ps.executeUpdate();

        if (updated > 0) {
            checkThreshold(itemId); // only check threshold if stock updated successfully
            return true;
        } else {
            return false;
        }
    }
}

// Private helper method to check if stock is below threshold
private void checkThreshold(Long itemId) {
    String sql = "SELECT name, quantity, threshold FROM items WHERE item_id=?";
    try (Connection con = DBUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setLong(1, itemId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int quantity = rs.getInt("quantity");
            int threshold = rs.getInt("threshold");
            String name = rs.getString("name");

            if (quantity < threshold) {
                System.out.println("⚠️ Stock Alert: Item '" + name + "' is below threshold!");
            }
        }
    } catch (SQLException e) {
        System.err.println("Error checking threshold for item ID " + itemId);
        e.printStackTrace();
    }
}


    // ---------- Existing remaining methods ---------- //

    public void updateQuantity(Long itemId, Integer quantity) throws SQLException {
        String sql = "UPDATE items SET quantity=? WHERE item_id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setLong(2, itemId);
            ps.executeUpdate();
        }
    }

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

    // ---------- SEARCH ITEMS ----------
public List<Item> searchItems(String name, String type) throws SQLException {
    StringBuilder sql = new StringBuilder("SELECT * FROM items WHERE 1=1");
    if (name != null && !name.isEmpty()) sql.append(" AND name LIKE ?");
    if (type != null && !type.isEmpty()) sql.append(" AND type LIKE ?");

    try (Connection con = DBUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql.toString())) {

        int index = 1;
        if (name != null && !name.isEmpty()) ps.setString(index++, "%" + name + "%");
        if (type != null && !type.isEmpty()) ps.setString(index++, "%" + type + "%");

        ResultSet rs = ps.executeQuery();
        List<Item> items = new java.util.ArrayList<>();

        while (rs.next()) {
            Item item = new Item();
            item.setItemId(rs.getLong("item_id"));
            item.setName(rs.getString("name"));
            item.setType(rs.getString("type"));
            item.setPrice(rs.getBigDecimal("price"));
            item.setQuantity(rs.getInt("quantity"));
            item.setThreshold(rs.getInt("threshold"));
            items.add(item);
        }
        return items;
    }
}

// ---------- FILTER ITEMS ----------
public List<Item> filterItems(Double minPrice, Double maxPrice, boolean availableOnly) throws SQLException {
    StringBuilder sql = new StringBuilder("SELECT * FROM items WHERE 1=1");
    if (minPrice != null) sql.append(" AND price >= ?");
    if (maxPrice != null) sql.append(" AND price <= ?");
    if (availableOnly) sql.append(" AND quantity > 0");

    try (Connection con = DBUtil.getConnection();
         PreparedStatement ps = con.prepareStatement(sql.toString())) {

        int index = 1;
        if (minPrice != null) ps.setDouble(index++, minPrice);
        if (maxPrice != null) ps.setDouble(index++, maxPrice);

        ResultSet rs = ps.executeQuery();
        List<Item> items = new java.util.ArrayList<>();

        while (rs.next()) {
            Item item = new Item();
            item.setItemId(rs.getLong("item_id"));
            item.setName(rs.getString("name"));
            item.setType(rs.getString("type"));
            item.setPrice(rs.getBigDecimal("price"));
            item.setQuantity(rs.getInt("quantity"));
            item.setThreshold(rs.getInt("threshold"));
            items.add(item);
        }
        return items;
    }
}

}
