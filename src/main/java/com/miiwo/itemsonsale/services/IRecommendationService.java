package com.miiwo.itemsonsale.services;

import java.util.Set;

import com.miiwo.itemsonsale.models.Item;

/**
 * An interface for what recommendation services should provide.
 */
public interface IRecommendationService {
    /**
     * Returns a set of recommended items for a certain user.
     * @param userId user's id
     * @return Set of items to recommend for said user
     */
    public Set<Item> getRecommendations(int userId);
}
