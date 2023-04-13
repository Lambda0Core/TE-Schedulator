package com.techelevator.controller;

import com.techelevator.dao.DetailsDao;
import com.techelevator.model.Details;
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

<<<<<<< HEAD:java/src/main/java/com/techelevator/controller/ProviderController.java
    @RequestMapping(path = "/provider/{id}", method = RequestMethod.GET)
    public Provider getProviderById(@PathVariable int id) {
        Provider provider = providerDao.getProviderById(id);
        if (provider == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found");
=======
    @RequestMapping(path = "/details/{id}", method = RequestMethod.GET)
    public Details getDetailsById(@RequestParam int id) {
        Details details = detailsDao.getDetailsById(id);
        if (details == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User details not found");
>>>>>>> 591f4b9c696065a1aafaa3d0cb72fe5666fabf95:java/src/main/java/com/techelevator/controller/DetailsController.java
        } else {

            return detailsDao.getDetailsById(id);
        }
    }

    @RequestMapping(path = "/providers/{officeId}", method = RequestMethod.GET)
    public List<Provider>  getProviderByOfficeId(@PathVariable int officeId) {
        List<Provider> providers =  providerDao.getProviderByOfficeId(officeId);
        if (providers == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Providers not found");
        } else {

            return providers;
        }
    }

//    @RequestMapping(path = "/provider/{id}", method = RequestMethod.GET)
//    public Provider getProviderByUserId(@RequestParam int id) {
//        Provider provider = providerDao.getProviderByUserId(id);
//        if (provider == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found");
//        } else {
//
//            return providerDao.getProviderByUserId(id);
//        }
//    }


<<<<<<< HEAD:java/src/main/java/com/techelevator/controller/ProviderController.java
    @RequestMapping(path = "/provider/{lastName}", method = RequestMethod.GET)
    public Provider getProviderIdByLastName(@PathVariable String lastName) {
        Provider provider = providerDao.getProviderIdByLastName(lastName);
        if (provider == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found");
=======
    @RequestMapping(path = "/details/{lastName}", method = RequestMethod.GET)
    public Details getDetailsIdByLastName(@RequestParam String lastName) {
        Details details = detailsDao.getDetailsIdByLastName(lastName);
        if (details == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User details not found");
>>>>>>> 591f4b9c696065a1aafaa3d0cb72fe5666fabf95:java/src/main/java/com/techelevator/controller/DetailsController.java
        } else {

            return detailsDao.getDetailsIdByLastName(lastName);
        }


    }

<<<<<<< HEAD:java/src/main/java/com/techelevator/controller/ProviderController.java
    @PostMapping("/provider")
    public boolean createProvider(@Valid @RequestBody Provider provider, @PathVariable int officeId, @PathVariable int userId, @PathVariable String firstName, @PathVariable String lastName, @PathVariable int titleId) {
        if (provider == null) {
=======
    @PostMapping("/details")
    public boolean createDetails(@Valid @RequestBody Details details, @RequestParam int userId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam boolean isProvider, @RequestParam int titleId) {
        if (details == null) {
>>>>>>> 591f4b9c696065a1aafaa3d0cb72fe5666fabf95:java/src/main/java/com/techelevator/controller/DetailsController.java
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 not found");
        }

        return detailsDao.create(userId, firstName, lastName, isProvider, titleId);
    }


}


