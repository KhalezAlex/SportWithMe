package com.swm.sportwithme.services.entityServices.cityService;

import com.swm.sportwithme.models.Country;


//дописать ссылку на страну
public interface CityService {
    void save(Long id, String name);
    Country getById(Long id);
}
