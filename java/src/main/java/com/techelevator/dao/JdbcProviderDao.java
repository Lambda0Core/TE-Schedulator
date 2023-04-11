package com.techelevator.dao;

import com.techelevator.model.Provider;
import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcProviderDao implements ProviderDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProviderDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate;}


    @Override
    public List<Provider> findAllProviders() {
        List<Provider> providers = new ArrayList<>();
        String sql = "select * from provider";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Provider provider = mapRowToProvider(results);
            providers.add(provider);
        }
        return providers;
    }

    @Override
    public Provider getProviderById(int providerId) {
        String sql = "SELECT * FROM provider WHERE provider_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, providerId);
        if (results.next()) {
            return mapRowToProvider(results);
        } else {
            return null;
        }
    }

    @Override
    public Provider getProviderByUserId(int userId) {
        String sql = "SELECT * FROM provider WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            return mapRowToProvider(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Provider> findAllByUserId(int userId) {
        List<Provider> providers = new ArrayList<>();
        String sql = "select * from provider where user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Provider provider = mapRowToProvider(results);
            providers.add(provider);
        }

        return providers;
    }

    @Override
    public List<Provider> findAllByProviderId(int providerId) {
        List<Provider> providers = new ArrayList<>();
        String sql = "select * from provider where provider_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, providerId);
        while (results.next()) {
            Provider provider = mapRowToProvider(results);
            providers.add(provider);
        }

        return providers;
    }

    private Provider mapRowToProvider(SqlRowSet rs) {
        Provider provider = new Provider();
        provider.setId(rs.getInt("provider_id"));
        provider.setOfficeId(rs.getInt("office_id"));
        provider.setUserId(rs.getInt("user_id"));
        provider.setFirstName(rs.getString("first_name"));
        provider.setLastName(rs.getString("last_name"));
        provider.setTitleId(rs.getInt("title_id"));
        provider.setDateAvailability(rs.getDate("date_availability").toLocalDate());
        return provider;
    }
}