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

    //private final String orderQuery = "SELECT UNIQUE(*) FROM Orders o LEFT JOIN (SELECT * FROM Products a JOIN SaleItems b ON a.id = b.product_id) p ON o.product_id = p.id WHERE o.user_id = ?";
    //private final String categoryQuery = "SELECT UNIQUE(*) FROM Products WHERE category = category";
    //private final String testOrderQuery = "SELECT * FROM Orders";
    private final String testCategoryQuery = "SELECT * FROM Products";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Set<Item> findOrdersFrom(String user) {
        Set<Item> orders = jdbcTemplate.query(testCategoryQuery, new ItemMapper()).stream().collect(Collectors.toSet());
        return orders;
    }

    public Set<Item> getItemsByCategory(String category) {
        Set<Item> items = jdbcTemplate.query(testCategoryQuery, new ItemMapper()).stream().collect(Collectors.toSet());
        return items;
    }
}
