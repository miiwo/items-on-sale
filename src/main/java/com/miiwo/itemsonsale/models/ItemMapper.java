package com.miiwo.itemsonsale.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Mapper class for the Item object.
 */
public class ItemMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Item(rs.getString("name"), rs.getDouble("price"), rs.getString("category"));
    }
    
}
