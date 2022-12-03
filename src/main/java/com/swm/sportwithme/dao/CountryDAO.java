package com.swm.sportwithme.dao;

import com.swm.sportwithme.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDAO extends JpaRepository<Country, Long> {
}
