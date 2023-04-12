package com.techelevator.controller;

import com.techelevator.dao.PatientDao;
import com.techelevator.model.Patient;
import com.techelevator.model.Provider;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class PatientController {

    PatientDao patientDao;

    public PatientController(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @RequestMapping(path = "/patient/", method = RequestMethod.GET)
    public List<Patient> findAllPatient() {
        return patientDao.findAllPatients();
    }

//    @RequestMapping(path = "/patient/{id}", method = RequestMethod.GET)
//    public List<Patient> findAllByUserId(@RequestParam int id) {
//        List<Patient> providers = patientDao.findAllByUserId(id);
//
//        if (providers == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Providers not found");
//        } else {
//
//            return patientDao.findAllByUserId(id);
//        }
//    }


    @RequestMapping(path = "/patient/{id}", method = RequestMethod.GET)
    public Patient getPatientById(@RequestParam int id) {
        Patient patient = patientDao.getPatientByPatientId(id);
        if (patient == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found");
        } else {

            return patientDao.getPatientByPatientId(id);
        }
    }
    @PostMapping("/patient")
    public boolean createPatient(@Valid @RequestBody Patient patient, @RequestParam String firstName, @RequestParam String lastName, @RequestParam int titleId, @RequestParam int userId) {
        if (patient == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 not found");
        }

        return patientDao.create(firstName, lastName, titleId, userId);
    }

}