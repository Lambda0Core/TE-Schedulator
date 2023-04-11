package com.techelevator.dao;

import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDao {

    List<Review> findAll();

    List<Review> findAllByUserId(int userId);

    List<Review> findAllByProviderId(int providerID);

    Review getReviewById(int reviewId);

    Review getReviewByUserId(int userId);

    Review findByReviewName(String reviewName);

    int findIdByReviewName(String reviewName);
}