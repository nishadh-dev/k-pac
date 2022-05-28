package com.aurosks.mapper;

import com.aurosks.models.KPac;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KPacRowMapper implements RowMapper<KPac> {
    @Override
    public KPac mapRow(ResultSet rs, int rowNum) throws SQLException {
        KPac kPac = new KPac();
        int id = rs.getInt("id");
        kPac.setId(id);
        kPac.setTitle(rs.getString("title"));
        kPac.setDescription(rs.getString("description"));
        LocalDate localDate = rs.getDate("creation_date").toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedString = localDate.format(formatter);
        kPac.setCreationDate(formattedString);
        kPac.setAction("<span style='color:red' class='delete-kpac' onclick='deleteKPac("+id+")'>Delete</span>");
        return kPac ;
    }
}
