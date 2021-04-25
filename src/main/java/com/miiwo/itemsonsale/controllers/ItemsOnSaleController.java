package com.miiwo.itemsonsale.controllers;

import java.util.Set;

import com.miiwo.itemsonsale.models.Item;
import com.miiwo.itemsonsale.services.IRecommendationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


/**
 * Class that contains all of the logic for the routes of the microservice.
 */
@RestController
public class ItemsOnSaleController {

    private IRecommendationService rs;

    @Autowired
    public ItemsOnSaleController(IRecommendationService rs) {
        this.rs = rs;
    }
    
    @GetMapping("/recommendations/{userId}")
    public ResponseEntity<Set<Item>> getRecommendedList(@RequestHeader("referer") String domain, 
                                                            @RequestHeader("authorization") Object userCreds,
                                                            @PathVariable String userId) {

        // Retrieve user's reccomended list
        Set<Item> recommendations = Set.of();
        
        try {
            recommendations = rs.getRecommendations(userId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something Happened");
        }
        
        return ResponseEntity.ok(recommendations);
    }
}
