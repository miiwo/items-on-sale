package com.miiwo.itemsonsale.services;

public interface IAuthorizationService {
    /**
     * Authenticates a user for a certain id in the database.
     * 
     * @param id id to check for
     * @param user client supplied username
     * @param pass client supplied password
     * @return True/False if the user can be authenticated
     */
    public boolean isValidCredentials(int id, String user, String pass);
}
