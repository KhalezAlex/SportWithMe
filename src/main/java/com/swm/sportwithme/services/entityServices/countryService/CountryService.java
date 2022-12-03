package com.swm.sportwithme.services.entityServices.countryService;


import com.swm.sportwithme.models.Country;

public interface CountryService {
//    void save(Long id, String name);
void save(String name);
    Country getByName(String countryName);
    Country getById(Long id);
}
