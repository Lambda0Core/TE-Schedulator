package com.techelevator.controller;

import com.techelevator.dao.OfficeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Office;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class OfficeController {

    private OfficeDao officeDao;

    public OfficeController(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }

    @GetMapping("/office")
    public List<Office> listAllOffices() {
        return officeDao.findAll();
    }

    @GetMapping("/office/{id}")
    public Office getOfficeById(@PathVariable int id) {

        Office office = officeDao.getOfficeById(id);
        if (office == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Office not found");
        } else {
        return officeDao.getOfficeById(id);
        }
    }

    @PostMapping("/office")
    public void createOffice(@RequestBody Office office) {
        officeDao.create(office);

    }

    @PutMapping("/office")
    public void updateOffice(@RequestBody Office office) {
        officeDao.update(office);

    }

    @DeleteMapping("/office/{id}")
    public void deleteOffice(@PathVariable int id) {
        officeDao.delete(id);
        // TODO Connect to DAO
    }
}
