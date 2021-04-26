package com.miiwo.itemsonsale.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.miiwo.itemsonsale.daos.IItemDAO;
import com.miiwo.itemsonsale.models.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MyRecommendationService class provides recommendations based on what the user has already bought.
 */
@Service
public class MyRecommendationService implements IRecommendationService {

    @Autowired
    private IItemDAO itemDao;

    /**
     * Returns recommendations for a specific user based on their past orders.
     * 
     * @param userId user's id
     * @return recommendations list
     */
    @Override
    public Set<Item> getRecommendations(int userId) {
        // Get all users orders
        Set<Item> userOrders = itemDao.findOrdersFrom(userId);

        // Find out what category does user buy the most from
        String userFavoriteCategory = findPopularCategory(userOrders);

        // Show user items from their favorite category that are on sale.
        Set<Item> recommendationList = itemDao.getItemsByCategory(userFavoriteCategory);

        // Remove any items they already have bought.
        recommendationList.removeIf(item -> userOrders.contains(item));
        

        return recommendationList;
    }

    /**
     * Helper method to find the most popular category from a set of Items.
     * 
     * @param list list to search for the most popular category
     * @return a string denoting the most popular category
     */
    private String findPopularCategory(Set<Item> list) {
        Map<String, Integer> popularHash = new HashMap<String, Integer>();

        // Log all of the categories and their frequencies
        for (Item item : list) {
            String category = item.getCategory();

            if (popularHash.containsKey(category)) {
                int freq = popularHash.get(category);
                popularHash.put(category, freq + 1);
            } else {
                popularHash.put(category, 0);
            }
        }

        // Figure out which is the most frequent
        Entry<String, Integer> max = null;

        for (Entry<String, Integer> entry : popularHash.entrySet()) {
            if (max == null || entry.getValue() > max.getValue()) {
                max = entry;
            }
        }

        return max == null ? null : max.getKey();
    }
    
}
