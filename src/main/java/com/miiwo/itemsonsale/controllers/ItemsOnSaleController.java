package com.miiwo.itemsonsale.controllers;

import java.util.List;

import com.miiwo.itemsonsale.models.Items;
import com.miiwo.itemsonsale.repository.UserReccomendationsRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsOnSaleController {
    
    @GetMapping("/recommendations/{userId}")
    public ResponseEntity<?> getRecommendedList(@RequestHeader("referer") String domain, 
                                    @RequestHeader("authorization") Object userCreds,
                                    @PathVariable int userId) {

        // Secure calls from certain domain
        if (!isSecureDomainCall(domain)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You cannot access.");
        }

        // Check user credentials
        if (!isUserValid(userCreds)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid user credentials");
        }

        // Retrieve user's reccomended list
        List<Items> reccomendations = findRecommendedList(userId);

        return ResponseEntity.status(HttpStatus.OK).body(reccomendations);
    }

    private boolean isUserValid(Object creds) {
        return true;
    }

    private boolean isSecureDomainCall(String domain) {
        return true;
    }

    private List<Items> findRecommendedList(int userId) {
        return List.of(new Items(0, "PJs", 3.4));
    }
}
