package com.swm.sportwithme.services.entityServices.countryService;

import com.swm.sportwithme.models.Country;

public interface CountryService {
    void save(Long id, String name);
    Country getById(Long id);
}
