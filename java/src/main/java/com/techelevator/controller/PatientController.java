package com.techelevator.controller;

import com.techelevator.dao.PatientDao;
import com.techelevator.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class PatientController {

    PatientDao patientDao;

    public PatientController(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Patient> findAllPatient() {
        return patientDao.findAllPatients();
    }

    @RequestMapping(path = "/patient/{id}", method = RequestMethod.GET)
    public List<Patient> findAllByUserId(@RequestParam int id) {
        List<Patient> providers = patientDao.findAllByUserId(id);

        if (providers == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Providers not found");
        } else {

            return patientDao.findAllByUserId(id);
        }
    }


    @RequestMapping(path = "/patient/{id}", method = RequestMethod.GET)
    public Patient getPatientById(@RequestParam int id) {
        Patient patient = patientDao.getPatientByPatientId(id);
        if (patient == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provider not found");
        } else {

            return patientDao.getPatientByPatientId(id);
        }
    }
}


