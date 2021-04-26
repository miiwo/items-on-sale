package com.miiwo.itemsonsale.services;

import com.miiwo.itemsonsale.daos.IUserDAO;
import com.miiwo.itemsonsale.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * My implementation of authorization.
 */
@Service
public class MyAuthorizationService implements IAuthorizationService {

    @Autowired
    private IUserDAO userDao;

    @Override
    public boolean isValidCredentials(int id, String username, String pass) {
        User user = userDao.find(id);
        return user.getUsername().equals(username) && user.getPassword().equals(pass);
    }
    
}
