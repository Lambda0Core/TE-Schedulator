package com.techelevator.model;

import java.time.LocalDate;

public class Provider {

    private int id;
    private int officeId;
    private int userId;
    private String firstName;
    private String lastName;
    private int titleId;
    private LocalDate dateAvailability;

    public Provider(int id, int officeId, int userId, String firstName, String lastName, int titleId, LocalDate dateAvailability) {
        this.id = id;
        this.officeId = officeId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.titleId = titleId;
        this.dateAvailability = dateAvailability;
    }

    public Provider() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public LocalDate getDateAvailability() {
        return dateAvailability;
    }

    public void setDateAvailability(LocalDate dateAvailability) {
        this.dateAvailability = dateAvailability;
    }
}
