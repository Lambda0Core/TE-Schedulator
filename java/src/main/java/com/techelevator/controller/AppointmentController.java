package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.model.Appointment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class AppointmentController {

    private AppointmentDao appointmentDao;

    public AppointmentController(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @GetMapping("/appointment/{id}")
    public Appointment getAppointmentById(@RequestParam int id) {
        Appointment appointment = appointmentDao.getAppointmentByAptId(id);
        if (appointment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found");
        } else {

            return appointmentDao.getAppointmentByAptId(id);
        }
    }

    @GetMapping("patient/appointment/{id}")
    public Appointment[] getPatientAppointments(@PathVariable int id) {
        List<Appointment> appointment = appointmentDao.getAppointmentsByUserId(id);
        if (appointment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found");
        } else {

            return appointment.toArray( new Appointment[]{} );
        }
    }

    @GetMapping("provider/appointment/{id}")
    public Appointment[] getProviderAppointments(@RequestParam int id) {
        Appointment appointment = (Appointment) appointmentDao.findAllAppointmentsByProviderId(id);
        if (appointment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found");
        } else {

            return new Appointment[]{(Appointment) appointmentDao.findAllAppointmentsByProviderId(id)};
        }
    }

    @PostMapping("/appointment")
    public void createAppointment(@RequestBody Appointment appointment) {
            appointmentDao.create(appointment);

    }

    @PutMapping("/appointment")
    public void updateAppointment(@RequestBody Appointment appointment) {
        appointmentDao.update(appointment);
    }

    @DeleteMapping("/appointment/{id}")
    public void deleteAppointment(@RequestParam int id) {
        appointmentDao.delete(id);
    }
}
