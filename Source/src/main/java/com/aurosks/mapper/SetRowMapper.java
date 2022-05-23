package com.aurosks.mapper;

import com.aurosks.models.Set;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SetRowMapper implements RowMapper<Set> {
    @Override
    public Set mapRow(ResultSet rs, int rowNum) throws SQLException {
        Set set = new Set();
        set.setId(rs.getInt("id"));
        set.setTitle(rs.getString("title"));
        return set ;
    }
}
