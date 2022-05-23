package com.aurosks.repository;

import com.aurosks.mapper.SetRowMapper;
import com.aurosks.models.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SetRepositoryImpl implements SetRepository{

    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SetRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean addSet(Set set) {
        String kpacSetQuery = "INSERT INTO k_pac_set (k_pac_id, set_id) VALUES (?, ?)";
        SimpleJdbcInsert simpleJdbcInsert =  new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("`set`").usingGeneratedKeyColumns("id");
        Map<String, Object> params = new HashMap<>();
        params.put("title", set.getTitle());
        Number id = simpleJdbcInsert.executeAndReturnKey(params);
        if(set.getkPacIds() != null) {
            for(Integer kpacId : set.getkPacIds()) {
                jdbcTemplate.update(kpacSetQuery, kpacId, id.intValue());
            }
        }
        return id.intValue() > 0;
    }

    @Override
    public List<Set> listSets() {
        String query = "SELECT id, title FROM `set`";
        return jdbcTemplate.query(query, new SetRowMapper());
    }

    @Override
    public boolean deleteSet(int id) {
        String updateQuery = "UPDATE k_pac_set SET set_id = NULL WHERE set_id=?" ;
        String query = "DELETE FROM `set` WHERE id = ?";
        jdbcTemplate.update(updateQuery, id);
        int rowsAffected = jdbcTemplate.update(query, id);
        return rowsAffected > 0;
    }
}
