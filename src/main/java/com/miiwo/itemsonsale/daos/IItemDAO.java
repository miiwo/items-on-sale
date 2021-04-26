package com.miiwo.itemsonsale.daos;

import java.util.Set;

import com.miiwo.itemsonsale.models.Item;

import org.springframework.stereotype.Repository;

@Repository
public interface IItemDAO {
    public Set<Item> findOrdersFrom(int userId);
    public Set<Item> getItemsByCategory(String category);
}
