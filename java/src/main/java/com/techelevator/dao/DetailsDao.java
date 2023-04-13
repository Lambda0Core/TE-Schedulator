package com.techelevator.dao;

import com.techelevator.model.Details;

import java.util.List;

public interface DetailsDao {

    List<Details> findAllDetails();

    Details getDetailsById(int detailsId);

    int getDetailsByOfficeId(int officeId);

    int getDetailsByUserId(int userId);

    Details getDetailsIdByLastName(String lastName);

    List<Details> findAllByUserId(int userId);

    List<Details> findAllByDetailsId(int detailsId);

    boolean create(int userId, String first_name, String last_name, boolean isProvider, int titleId);

}
