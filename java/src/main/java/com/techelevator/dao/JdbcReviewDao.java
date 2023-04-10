package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.techelevator.model.Office;
import com.techelevator.model.Review;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

public class JdbcReviewDao implements ReviewDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> findAll() {
        List<Review> reviews = new ArrayList<>();
        String sql = "select * from review";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Review review = mapRowToReview(results);
            reviews.add(review);
        }

        return reviews;
    }

    @Override
    public List<Review> findAllByUserId(int userId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "select * from review where user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Review review = mapRowToReview(results);
            reviews.add(review);
        }

        return reviews;
    }

    @Override
    public List<Review> findAllByProviderId(int providerId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "select * from review where provider_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, providerId);
        while (results.next()) {
            Review review = mapRowToReview(results);
            reviews.add(review);
        }

        return reviews;
    }

    @Override
    public Review getReviewById(int reviewId) {
        String sql = "SELECT * FROM review WHERE review_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewId);
        if (results.next()) {
            return mapRowToReview(results);
        } else {
            return null;
        }

    }


    @Override
    public Review getReviewByUserId(int userId) {
        String sql = "SELECT * FROM review WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            return mapRowToReview(results);
        } else {
            return null;
        }
    }

    @Override
    public Review findByReviewName(String reviewName) {
        if (reviewName == null) throw new IllegalArgumentException("Review Title cannot be null");

        for (Review review : this.findAll()) {
            if (review.getReviewTitle().equalsIgnoreCase(reviewName)) {
                return review;
            }
        }
        throw new UsernameNotFoundException(reviewName + " was not found...");
    }

    @Override
    public int findIdByReviewName(String reviewName) {
        if (reviewName == null) throw new IllegalArgumentException("Review Title cannot be null");

        int reviewId;
        try {
            reviewId = jdbcTemplate.queryForObject("select review_id from review where review_title = ?", int.class, reviewName);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException(reviewName + " was not found...");
        }

        return reviewId;
    }

        private Review mapRowToReview(SqlRowSet rs) {
        Review review = new Review();
        review.setReviewId(rs.getInt("review_id"));
        review.setReviewTitle(rs.getString("review_title"));
        review.setReviewDesc(rs.getString("review_desc"));
        review.setUserId(rs.getInt("user_id"));
        review.setProviderId(rs.getInt("provider_id"));
        return review;
    }

}
