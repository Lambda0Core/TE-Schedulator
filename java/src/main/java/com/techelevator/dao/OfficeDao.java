package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDao {

    List<Office> findAll();

    Office getOfficeById(int officeId);

    Office findByAddress(String address);

    int findIdByAddress(String address);

}