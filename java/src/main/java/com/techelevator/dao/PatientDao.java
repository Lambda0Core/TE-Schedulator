package com.techelevator.dao;

import com.techelevator.model.Patient;


import java.util.List;

public interface PatientDao {

    List<Patient> findAllPatients();

    Patient getPatientByPatientId(int patientId);

    List<Patient> findAllByUserId(int id);

    Patient getPrinciplePatient(int patientId);

    boolean create(String first_name, String last_name, int titleId, int userId);


}
