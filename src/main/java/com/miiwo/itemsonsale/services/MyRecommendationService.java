package com.miiwo.itemsonsale.services;

import java.util.Set;

import com.miiwo.itemsonsale.daos.IItemDAO;
import com.miiwo.itemsonsale.models.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service layer that provides business logic to the controller. This layer should not have database queries in it.
 * This class focuses on providing recommendations by what the user has already bought, and any new items that come
 * into the shop.
 */
@Service
public class MyRecommendationService implements IRecommendationService {

    @Autowired
    private IItemDAO itemDao;

    public MyRecommendationService() {}

    /**
     * Returns recommendations to user based on their past orders, and other users' purchases.
     */
    @Override
    public Set<Item> getRecommendations(int userId) {
        // Get all users orders
        Set<Item> userOrders = itemDao.findOrdersFrom(userId);

        // Find out what category does user buy the most from
        String userFavoriteCategory = findPopularCategory(userOrders);

        // Show user items from their favorite category that are on sale.
        Set<Item> recommendationList = itemDao.getItemsByCategory(userFavoriteCategory);
        System.out.println(recommendationList);

        // Remove any items they already have bought.
        recommendationList.removeIf(item -> userOrders.contains(item));
        System.out.println(recommendationList);
        // Filter the items by date, take items that have recently come into sale. (2 weeks)
        //recommendationList.removeIf(item -> item.dateAdded - Current.Date < 2 weeks);

        // Note: I could also cross reference with other users what they bought when they share the same favorite category as user.

        return recommendationList;
    }

    /**
     * Helper method to find the category that is the most popular.
     * @param list
     * @return
     */
    private String findPopularCategory(Set<Item> list) {
        return "Electronics";
    }
    
}
