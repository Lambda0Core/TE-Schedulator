package com.techelevator.dao;

import com.techelevator.model.Provider;

import java.util.List;

public interface ProviderDao {

    List<Provider> findAllProviders();

    Provider getProviderById(int providerId);

    Provider getProviderByOfficeId(int officeId);

    Provider getProviderByUserId(int userId);

    Provider getProviderIdByLastName(String lastName);

    List<Provider> findAllByUserId(int userId);

    List<Provider> findAllByProviderId(int providerId);

    boolean create(int officeId, int userId, String first_name, String last_name, int titleId);

}
