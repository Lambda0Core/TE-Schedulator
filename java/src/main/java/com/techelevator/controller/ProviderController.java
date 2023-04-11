package com.techelevator.controller;

import com.techelevator.dao.ProviderDao;
import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Provider;
import com.techelevator.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ProviderController {

    ProviderDao providerDao;

    public ProviderController(ProviderDao providerDao) {
        this.providerDao = providerDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Provider> findAllProviders() {
        return providerDao.findAllProviders();
    }

    @RequestMapping(path = "/provider/{id}", method = RequestMethod.GET)
    public List<Provider> findAllProvidersById(@RequestParam int id) {
        List<Provider> providers = providerDao.findAllByProviderId(id);

        if (providers == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Providers not found");
        } else {

            return providerDao.findAllByProviderId(id);
        }
    }

    @RequestMapping(path = "/provider/{id}", method = RequestMethod.GET)
    public List<Provider> findAllByUserId(@RequestParam int id) {
        List<Provider> providers = providerDao.findAllByUserId(id);

        if (providers == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Providers not found");
        } else {

            return providerDao.findAllByUserId(id);
        }
    }

    @RequestMapping(path = "/provider/{id}", method = RequestMethod.GET)
    public Provider getProviderById(@RequestParam int id) {
        Provider provider = providerDao.getProviderById(id);
        if (provider == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found");
        } else {

            return providerDao.getProviderById(id);
        }
    }

    @RequestMapping(path = "/provider/{id}", method = RequestMethod.GET)
    public Provider getProviderByUserId(@RequestParam int id) {
        Provider provider = providerDao.getProviderByUserId(id);
        if (provider == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found");
        } else {

            return providerDao.getProviderByUserId(id);
        }
    }


    @RequestMapping(path = "/provider/{lastName}", method = RequestMethod.GET)
    public Provider getProviderIdByLastName(@RequestParam String lastName) {
        Provider provider = providerDao.getProviderIdByLastName(lastName);
        if (provider == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found");
        } else {

            return providerDao.getProviderIdByLastName(lastName);
        }


    }
//    @RequestMapping(path = "/provider/{id}", method = RequestMethod.GET)
//    String getProviderFirstNameById(@RequestParam int id) {
//        String provider = providerDao.getProviderFirstNameById(id);
//
//        if (provider == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Providers not found");
//        } else {
//
//            return providerDao.getProviderFirstNameById(id);
//        }
//    }


}


