package com.miiwo.itemsonsale.daos;

import com.miiwo.itemsonsale.models.User;

import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO {
    public User find(int id);
}
