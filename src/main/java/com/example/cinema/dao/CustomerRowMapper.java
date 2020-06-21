package com.example.cinema.dao;

import org.springframework.jdbc.core.RowMapper;

import com.example.cinema.entities.Film;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Film> {

    @Override
    public Film mapRow(ResultSet rs, int rowNum) throws SQLException {

        Film customer = new Film();
        customer.setTitre(rs.getString("titre"));

        return customer;

    }
}