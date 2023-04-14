package com.techelevator.controller;

import com.techelevator.dao.DetailsDao;
import com.techelevator.model.Details;
import com.techelevator.model.Office;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class DetailsController {

    DetailsDao detailsDao;

    public DetailsController(DetailsDao detailsDao) {
        this.detailsDao = detailsDao;
    }

    @RequestMapping(path = "/details", method = RequestMethod.GET)
    public List<Details> findAllDetails() {
        return detailsDao.findAllDetails();
    }

//    @RequestMapping(path = "/provider/{id}", method = RequestMethod.GET)
//    public List<Provider> findAllProvidersById(@RequestParam int id) {
//        List<Provider> providers = providerDao.findAllByProviderId(id);
//
//        if (providers == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Providers not found");
//        } else {
//
//            return providerDao.findAllByProviderId(id);
//        }
//    }
//
//    @RequestMapping(path = "/provider/{id}", method = RequestMethod.GET)
//    public List<Provider> findAllByUserId(@RequestParam int id) {
//        List<Provider> providers = providerDao.findAllByUserId(id);
//
//        if (providers == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Providers not found");
//        } else {
//
//            return providerDao.findAllByUserId(id);
//        }
//    }

    @RequestMapping(path = "/details/{id}", method = RequestMethod.GET)
    public Details getDetailsById(@PathVariable int id) {
        Details details = detailsDao.getDetailsById(id);
        if (details == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User details not found");
        } else {

            return detailsDao.getDetailsById(id);
        }
    }

    @RequestMapping(path = "provider/details/{id}", method = RequestMethod.GET)
    public Details getProviderDetailsById(@PathVariable int id) {
        Details details = detailsDao.getDetailsById(id);
        if (details == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User details not found");
        } else {

            return detailsDao.getDetailsById(id);
        }
    }

    // TODO This path was ambiguous and needs to fixed
    @RequestMapping(path = "office/details/{id}", method = RequestMethod.GET)
    public List<Details> getDetailsByOfficeId(@PathVariable int id) {
        return detailsDao.getDetailsByOfficeId(id);
    }



    // TODO This path was ambiguous and needs to fixed
//    @RequestMapping(path = "/details/{lastName}", method = RequestMethod.GET)
//    public Details getDetailsIdByLastName(@RequestParam String lastName) {
//        Details details = detailsDao.getDetailsIdByLastName(lastName);
//        if (details == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User details not found");
//        } else {
//
//            return detailsDao.getDetailsIdByLastName(lastName);
//        }
//
//
//    }

    @PostMapping("/details")
    public boolean create(@Valid @RequestBody Details details, @RequestParam int userId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam boolean isProvider, @RequestParam int titleId) {
        if (details == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 not found");
        }

        return detailsDao.create(userId, firstName, lastName, isProvider, titleId);
    }

    @PostMapping("/details/provider")
    public boolean createProvider(@Valid @RequestBody Details details, @RequestParam int userId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam boolean isProvider, @RequestParam int titleId, @RequestParam int officeId) {
        if (details == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 not found");
        }

        return detailsDao.createProvider(userId, firstName, lastName, isProvider, titleId, officeId);
    }



}


