package com.aurosks.mapper;

import com.aurosks.models.Set;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SetRowMapper implements RowMapper<Set> {
    @Override
    public Set mapRow(ResultSet rs, int rowNum) throws SQLException {
        Set set = new Set();
        int id = rs.getInt("id");
        set.setId(id);
        set.setTitle(rs.getString("title"));
        set.setAction("<span style='color:red' class='delete-set' onclick='deleteSet("+id+")'>Delete</span>");
        return set ;
    }
}
