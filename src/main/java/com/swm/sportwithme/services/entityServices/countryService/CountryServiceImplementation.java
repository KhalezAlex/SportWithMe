package com.swm.sportwithme.services.entityServices.countryService;

import com.swm.sportwithme.models.Country;
import com.swm.sportwithme.dao.CountryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImplementation implements CountryService{
    @Autowired
    CountryDAO countryDAO;

    @Override
    public void save(Long id, String name) {

    }

    @Override
    public Country getById(Long id) {
        return null;
    }
}
