package com.miiwo.itemsonsale.daos;

import java.util.Set;

import com.miiwo.itemsonsale.models.Item;

public interface IItemDAO {
    public Set<Item> findOrdersFrom(String user);
    public Set<Item> getItemsByCategory(String category);
}