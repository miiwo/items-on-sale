package com.miiwo.itemsonsale.services;

import java.util.Set;

import com.miiwo.itemsonsale.models.Item;

/**
 * An interface for what recommendation services should provide.
 */
public interface IRecommendationService {
    public Set<Item> getRecommendations(String user);
}
