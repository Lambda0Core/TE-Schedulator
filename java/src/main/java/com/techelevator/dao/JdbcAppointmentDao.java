package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.model.Appointment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        String sql =
                "SELECT\n" +
                "a.apt_id,\n" +
                "a.apt_name,\n" +
                "a.apt_status,\n" +
                "a.apt_agenda,\n" +
                "a.apt_date,\n" +
                "a.user_id,\n" +
                "a.provider_id,\n" +
                "pr.first_name AS provider_last_name,\n" +
                "pr.last_name AS provider_first_name,\n" +
                "pa.first_name AS patient_last_name,\n" +
                "pa.last_name AS patient_first_name\n" +
                "FROM appointment a\n" +
                "JOIN provider pr ON pr.provider_id = a.provider_id\n" +
                "JOIN patient pa ON pa.user_id = a.user_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public Appointment getAppointmentByAptId(int aptId) {
        String sql =
                "SELECT\n" +
                "a.apt_id,\n" +
                "a.apt_name,\n" +
                "a.apt_status,\n" +
                "a.apt_agenda,\n" +
                "a.apt_date,\n" +
                "a.user_id,\n" +
                "a.provider_id,\n" +
                "pr.first_name AS provider_first_name,\n" +
                "pr.last_name AS provider_last_name,\n" +
                "pa.first_name AS patient_first_name,\n" +
                "pa.last_name AS patient_last_name\n" +
                "FROM appointment a\n" +
                "JOIN provider pr ON pr.provider_id = a.provider_id\n" +
                "JOIN patient pa ON pa.user_id = a.user_id\n" +
                "WHERE a.apt_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, aptId);
        if (results.next()) {
            return mapRowToAppointment(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Appointment> getAppointmentsByUserId(int userId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql =
                "SELECT\n" +
                "a.apt_id,\n" +
                "a.apt_name,\n" +
                "a.apt_status,\n" +
                "a.apt_agenda,\n" +
                "a.apt_date,\n" +
                "a.user_id,\n" +
                "a.provider_id,\n" +
                "pr.first_name AS provider_first_name,\n" +
                "pr.last_name AS provider_last_name,\n" +
                "pa.first_name AS patient_first_name,\n" +
                "pa.last_name AS patient_last_name\n" +
                "FROM appointment a\n" +
                "JOIN provider pr ON pr.provider_id = a.provider_id\n" +
                "JOIN patient pa ON pa.user_id = a.user_id\n" +
                "WHERE a.user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            Appointment appointment = mapRowToAppointment(results);
            appointments.add(appointment);
        }
        return appointments;
    }

    @Override
    public List <Appointment> findAllAppointmentsByProviderId(int providerId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql =
                "SELECT\n" +
                "a.apt_id,\n" +
                "a.apt_name,\n" +
                "a.apt_status,\n" +
                "a.apt_agenda,\n" +
                "a.apt_date,\n" +
                "a.user_id,\n" +
                "a.provider_id,\n" +
                "pr.first_name AS provider_first_name,\n" +
                "pr.last_name AS provider_last_name,\n" +
                "pa.first_name AS patient_first_name,\n" +
                "pa.last_name AS patient_last_name\n" +
                "FROM appointment a\n" +
                "JOIN provider pr ON pr.provider_id = a.provider_id\n" +
                "JOIN patient pa ON pa.user_id = a.user_id\n" +
                "WHERE a.provider_id = ?";;
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

    @Override
    public void create(Appointment appointment) {

        try {
            String sql = "INSERT INTO public.appointment(\n" +
                    "\tapt_id, apt_name, apt_status, apt_agenda, apt_date, user_id, provider_id)\n" +
                    "\tVALUES (?, ?, ?, ?, ?, ?, ?);";
            jdbcTemplate.queryForObject(sql, Integer.class, appointment.getStatus(),
                    appointment.getAgenda(), appointment.getDate(),
                    appointment.getUserId(), appointment.getProviderId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return;
    }

    @Override
    public void update(Appointment appointment) {

        try {
            String sql = "UPDATE public.appointment\n" +
                    "\tSET apt_id=?, apt_name=?, apt_status=?, apt_agenda=?, apt_date=?, user_id=?, provider_id=?\n" +
                    "\tWHERE appointment_id =?;";
            jdbcTemplate.update(sql, appointment.getId(), appointment.getName(),
                    appointment.getStatus(), appointment.getDate(),
                    appointment.getAgenda(), appointment.getDate(),
                    appointment.getUserId(), appointment.getProviderId());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return;
    }

    @Override
    public void delete(int id) {
        try{
            String sql = "DELETE FROM public.appointment\n" +
                    "\tWHERE appointment_id =?;";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return;
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
        appointment.setProviderFirstName(rs.getString("provider_first_name"));
        appointment.setProviderLastName(rs.getString("provider_last_name"));
        appointment.setPatientFirstName(rs.getString("patient_first_name"));
        appointment.setPatientLastName(rs.getString("patient_last_name"));
        return appointment;
    }
}
