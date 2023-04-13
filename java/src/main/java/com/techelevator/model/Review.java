package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Review {

    private int reviewId;
    private String reviewTitle;
    private String reviewDesc;
    private int userId;
    private int detailsId;

    public Review(int reviewId, String reviewTitle, String reviewDesc, int userId, int detailsId) {
        this.reviewId = reviewId;
        this.reviewTitle = reviewTitle;
        this.reviewDesc = reviewDesc;
        this.userId = userId;
        this.detailsId = detailsId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public Review() { }


}

