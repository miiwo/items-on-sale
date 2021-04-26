package com.miiwo.itemsonsale.daos;

import com.miiwo.itemsonsale.models.User;
import com.miiwo.itemsonsale.models.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements IUserDAO {

    private final String userQuery = "SELECT username, pass FROM Users WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User find(int id) {
        User user = jdbcTemplate.queryForObject(userQuery, new UserMapper(), id);
        return user;
    }
    
}
