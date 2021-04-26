package com.miiwo.itemsonsale.daos;

import java.util.Set;

import com.miiwo.itemsonsale.models.Item;

import org.springframework.stereotype.Repository;

/**
 * An interface specifying what a DAO for an Item should look like.
 */
@Repository
public interface IItemDAO {
    /**
     * Returns all of the items that a user has ever ordered.
     * @param userId user id
     * @return a set of items that the user has ordered.
     */
    public Set<Item> findOrdersFrom(int userId);
    /**
     * Returns all of the items that are of the specified category
     * @param category category to filter by
     * @return a set of items that are of the specified category
     */
    public Set<Item> getItemsByCategory(String category);
}
