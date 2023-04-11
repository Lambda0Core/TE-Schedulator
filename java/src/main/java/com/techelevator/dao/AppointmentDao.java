package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.util.List;

public interface AppointmentDao {

    List<Appointment> findAllAppointments();

    Appointment getAppointmentByAptId(int aptId);

    Appointment getAppointmentsByUserId(int userId);

    List<Appointment> findAllAppointmentsByProviderId(int providerId);

    int findIdByAptName(String aptName);

    void create(Appointment appointment);

    void update(Appointment appointment);

    void delete(int id);
}
