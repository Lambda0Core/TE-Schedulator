package com.techelevator.controller;
import com.techelevator.model.Response;
import com.techelevator.dao.ResponsesDao;
import com.techelevator.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class ResponseController {

    ResponsesDao responsesDao;

    public ResponseController(ResponsesDao responsesDao) {
        this.responsesDao = responsesDao;
    }

    @GetMapping("/response")
    public List<Response> listAll() {
        return responsesDao.findAll();
    }

    @RequestMapping(path = "/response/{id}", method = RequestMethod.GET)
    public Response getResponseById(@PathVariable int id) {
        Response response = responsesDao.getResponseById(id);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response not found");
        } else {

            return responsesDao.getResponseById(id);
        }
    }

    @RequestMapping(path = "review/response/{id}", method = RequestMethod.GET)
    public Response getResponseByReviewId(@PathVariable int id) {
        Response response = responsesDao.getResponseByReviewId(id);
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response not found");
        } else {

            return responsesDao.getResponseByReviewId(id);
        }
    }


    @PostMapping("/response")
    public boolean createReview(@RequestBody Response response, @RequestParam int reviewId, @RequestParam String responseTitle, @RequestParam String responseDesc, @RequestParam int userId, @RequestParam int detailsId) {
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response not found");
        }

        return responsesDao.create(reviewId, responseTitle, responseDesc, userId, detailsId);
    }

}