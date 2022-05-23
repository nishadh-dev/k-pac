package com.aurosks.repository;

import com.aurosks.mapper.KPacRowMapper;
import com.aurosks.models.KPac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class KPacRepositoryImpl implements KPacRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public KPacRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean addKPac(KPac pac) {
        String query = "INSERT INTO k_pac (title, description, creation_date) VALUES (?, ?, ?)";
        LocalDate date = LocalDate.now();
        int rowsAffected = jdbcTemplate.update(query, pac.getTitle(), pac.getDescription(), date);
        return rowsAffected > 0;
    }

    @Override
    public List<KPac> listKPacs() {
        String query = "SELECT id, title, description, creation_date FROM k_pac";
        return jdbcTemplate.query(query, new KPacRowMapper());
    }

    @Override
    public boolean deleteKPac(int id) {
        String updateQuery = "UPDATE k_pac_set SET k_pac_id = NULL WHERE k_pac_id=?" ;
        String query = "DELETE FROM k_pac WHERE id = ?";
        jdbcTemplate.update(updateQuery, id);
        int rowsAffected = jdbcTemplate.update(query, id);
        return rowsAffected > 0;
    }

    @Override
    public List<KPac> findKPacBySet(int setId) {
        String query = "SELECT k_pac.id, title, description, creation_date FROM k_pac JOIN k_pac_set ON k_pac.id = k_pac_set.k_pac_id where set_id = ?";
        return jdbcTemplate.query(query, new Object[] {setId}, new KPacRowMapper());
    }
}
