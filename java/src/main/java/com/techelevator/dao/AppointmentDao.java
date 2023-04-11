package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.util.List;

public interface AppointmentDao {

    List<Appointment> findAllAppointments();

    Appointment getAppointmentByAptId(int aptId);

    List<Appointment> getAppointmentsByUserId(int userId);

    List<Appointment> findAllAppointmentsByProviderId(int providerId);

    int findIdByAptName(String aptName);

}
