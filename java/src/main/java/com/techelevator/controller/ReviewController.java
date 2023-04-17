package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Details;
import com.techelevator.model.Office;
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

    @GetMapping("/review")
    public List<Review> listAll() {
        return reviewDao.findAll();
    }

    @RequestMapping(path = "/details/listreview/{id}", method = RequestMethod.GET)
    public List<Review> listAllByDetails(@PathVariable int id) {
        return reviewDao.findAllByDetailsId(id);
    }

    @RequestMapping(path = "/users/listreview/{id}", method = RequestMethod.GET)
    public List<Review> listAllByUsers(@PathVariable int id) {
        return reviewDao.findAllByUserId(id);
    }


    @RequestMapping(path = "/review/{id}", method = RequestMethod.GET)
    public Review getReviewById(@PathVariable int id) {
        Review review = reviewDao.getReviewById(id);
        if (review == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        } else {

            return reviewDao.getReviewById(id);
        }
    }


    @RequestMapping(path = "/details/review/{id}", method = RequestMethod.GET)
    public Review[] getDetailsReviews(@PathVariable int id) {
        List<Review> review = reviewDao.findAllByDetailsId(id);
        if (review == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        } else {

            return review.toArray( new Review[]{} );
        }
    }

    @PostMapping("/review")
    public boolean createReview(@Valid @RequestBody Review review) {
        if (review == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review not found");
        }

        return reviewDao.create(review.getReviewTitle(), review.getReviewDesc(), review.getRating(), review.getUserId(), review.getDetailsId());
    }

}
