package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.techelevator.model.Appointment;
import com.techelevator.model.Office;
import com.techelevator.model.Review;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JdbcAppointmentDao implements AppointmentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Appointment> findAllAppointments() {
        List<Appointment> appointments= new ArrayList<>();
        String sql = "select * from appointment";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public Appointment getAppointmentByAptId(int aptId) {
        String sql = "SELECT * FROM appointment WHERE apt_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, aptId);
        if (results.next()) {
            return mapRowToAppointment(results);
        } else {
            return null;
        }
    }

    @Override
    public Appointment getAppointmentsByUserId(int userId) {
        String sql = "SELECT * FROM appointment WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            return mapRowToAppointment(results);
        } else {
            return null;
        }
    }

    @Override
    public List <Appointment> findAllAppointmentsByProviderId(int providerId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "select * from appointment where provider_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, providerId);
        while (results.next()) {
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public int findIdByAptName(String aptName) {
        if (aptName == null) throw new IllegalArgumentException("Appointment name cannot be null");

        int aptId;
        try {
            aptId = jdbcTemplate.queryForObject("select apt_id from appointment where apt_name = ?", int.class, aptName);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException(aptName + " was not found...");
        }
        return aptId;
    }

    private Appointment mapRowToAppointment(SqlRowSet rs) {
        Appointment appointment = new Appointment();
        appointment.setId(rs.getInt("apt_id"));
        appointment.setName(rs.getString("apt_name"));
        appointment.setStatus(rs.getString("apt_status"));
        appointment.setAgenda(rs.getString("apt_agenda"));
        appointment.setDate(rs.getDate("apt_date").toLocalDate());
        appointment.setUserId(rs.getInt("user_id"));
        appointment.setProviderId(rs.getInt("provider_id"));
        return appointment;
    }
}
