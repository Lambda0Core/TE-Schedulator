package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.techelevator.model.Office;
import com.techelevator.model.Patient;
import com.techelevator.model.Review;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JdbcPatientDao implements PatientDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPatientDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate; }


    @Override
    public List<Patient> findAllPatients() {
        List<Patient> patients= new ArrayList<>();
        String sql = "select * from patient";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Patient patient = mapRowToPatient(results);
            patients.add(patient);
        }
        return patients;
    }

    @Override
    public Patient getPatientByPatientId(int patientId) {
        String sql = "SELECT * FROM patient WHERE patient_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        if (results.next()) {
            return mapRowToPatient(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Patient> findAllByUserId(int userId) {
        List<Patient> patients = new ArrayList<>();
        String sql = "select * from patient where user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Patient patient = mapRowToPatient(results);
            patients.add(patient);
        }

        return patients;
    }

    private Patient mapRowToPatient(SqlRowSet rs) {
        Patient patient = new Patient();
        patient.setId(rs.getInt("patient_id"));
        patient.setFirstName(rs.getString("first_name"));
        patient.setLastName(rs.getString("last_name"));
        patient.setTitleId(rs.getInt("title_id"));
        patient.setUserId(rs.getInt("user_id"));
        return patient;
    }
}
