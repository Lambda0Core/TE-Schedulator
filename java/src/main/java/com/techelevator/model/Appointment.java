package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment {

    private int id;
    private String name;
    private String status;
    private String agenda;
    private LocalDate date;
    private int userId;
    private int providerId;

    public Appointment() {}

    public Appointment(int id, String name, String status, String agenda,
                       LocalDate date, int userId, int providerId) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.agenda = agenda;
        this.date = date;
        this.userId = userId;
        this.providerId = providerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
}
