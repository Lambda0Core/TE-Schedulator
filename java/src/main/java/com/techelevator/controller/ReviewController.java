package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {

    ReviewDao reviewDao;

    public ReviewController(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @GetMapping("/review/{id}")
    public Review getReviewById(@RequestParam int id) {
        Review review = reviewDao.getReviewById(id);
        if (review == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        } else {

            return reviewDao.getReviewById(id);
        }
    }


    @GetMapping("/provider/review/{id}")
    public Review[] getProviderReviews(@RequestParam int id) {
        List<Review> review = reviewDao.findAllByProviderId(id);
        if (review == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        } else {

            return review.toArray( new Review[]{} );
        }
    }

    @PostMapping("/provider/review")
    public boolean createProviderReview(@Valid @RequestBody Review review, @RequestParam String reviewTitle, @RequestParam String reviewDesc, @RequestParam int providerId) {
        if (review == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        }

        return reviewDao.create(reviewTitle, reviewDesc, providerId);
    }

}
