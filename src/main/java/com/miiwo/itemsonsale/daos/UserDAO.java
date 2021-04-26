package com.miiwo.itemsonsale.daos;

import com.miiwo.itemsonsale.models.User;
import com.miiwo.itemsonsale.models.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Concrete class that implements the IUserDAO interface. Used as an intermediary for Users from the database
 * to the application.
 */
@Repository
public class UserDAO implements IUserDAO {

    private final String userQuery = "SELECT username, pass FROM Users WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User find(int id) throws DataAccessException {
        User user = jdbcTemplate.queryForObject(userQuery, new UserMapper(), id);
        return user;
    }
    
}
