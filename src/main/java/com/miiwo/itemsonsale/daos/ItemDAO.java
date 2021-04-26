package com.miiwo.itemsonsale.daos;

import java.util.Set;
import java.util.stream.Collectors;

import com.miiwo.itemsonsale.models.Item;
import com.miiwo.itemsonsale.models.ItemMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO implements IItemDAO {

    private final String orderQuery = "SELECT * FROM Products WHERE id IN (SELECT product_id FROM Orders WHERE user_id = ?)";
    private final String categoryQuery = "SELECT * FROM Products WHERE category = ?";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Set<Item> findOrdersFrom(int userId) {
        // Surround these queries with try/catch
        Set<Item> orders = jdbcTemplate.query(orderQuery, new ItemMapper(), userId).stream().collect(Collectors.toSet());
        return orders;
    }

    public Set<Item> getItemsByCategory(String category) {
        Set<Item> items = jdbcTemplate.query(categoryQuery, new ItemMapper(), category).stream().collect(Collectors.toSet());
        return items;
    }
}
