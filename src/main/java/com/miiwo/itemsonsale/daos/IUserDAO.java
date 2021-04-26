package com.miiwo.itemsonsale.daos;

import com.miiwo.itemsonsale.models.User;

import org.springframework.stereotype.Repository;

/**
 * An interface specifying how to implement a UserDAO.
 */
@Repository
public interface IUserDAO {
    /**
     * Finds a specific user with the given unique id.
     * @param id user id to search for
     * @return a user object with a corresponding user in the database
     */
    public User find(int id);
}
