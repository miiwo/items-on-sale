package com.miiwo.itemsonsale.daos;

import java.util.Set;

import com.miiwo.itemsonsale.models.Item;

import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO implements IItemDAO {
    public Set<Item> findOrdersFrom(String user) {
        return Set.of(new Item("Sushi Plush", 4.58));
    }

    public Set<Item> getItemsByCategory(String category) {
        return Set.of(new Item("Penguins", 2.14));
    }
}
