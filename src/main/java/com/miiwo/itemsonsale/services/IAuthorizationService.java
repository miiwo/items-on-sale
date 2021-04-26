package com.miiwo.itemsonsale.services;

public interface IAuthorizationService {
    public boolean isValidCredentials(int id, String user, String pass);
}
