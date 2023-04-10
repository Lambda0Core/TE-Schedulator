package com.techelevator.controller;

import com.techelevator.dao.OfficeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Office;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class OfficeController {

    private OfficeDao officeDao;

    public OfficeController(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

    @GetMapping("/office")
    public Office[] listAllOffices() {
        // TODO Connect to DAO
        return null;
    }

    @GetMapping("/office/{id}")
    public Office getOfficeById(@RequestParam int id) {
        // TODO Connect to DAO
        return null;
    }

    @PostMapping("/office")
    public void createOffice() {
        // TODO Connect to DAO
    }

    @PutMapping("/office/{id}")
    public void updateOffice(@RequestParam int id) {
        // TODO Connect to DAO
    }

    @DeleteMapping("/office/{id}")
    public void deleteOffice(@RequestParam int id) {
        // TODO Connect to DAO
    }
}
