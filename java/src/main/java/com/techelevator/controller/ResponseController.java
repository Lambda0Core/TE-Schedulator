package com.techelevator.controller;
import com.techelevator.model.Response;
import com.techelevator.dao.ResponsesDao;
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

    @PostMapping("/response")
    public boolean createReview(@RequestBody Response response, @RequestParam int reviewId, @RequestParam String responseTitle, @RequestParam String responseDesc, @RequestParam int userId, @RequestParam int detailsId) {
        if (response == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response not found");
        }

        return responsesDao.create(reviewId, responseTitle, responseDesc, userId, detailsId);
    }

}