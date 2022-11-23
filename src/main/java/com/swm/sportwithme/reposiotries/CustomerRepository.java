package com.swm.sportwithme.reposiotries;

import com.swm.sportwithme.models.CustomersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomersModel, Long> {
    Optional<CustomersModel> findByLogin(String login);
    Optional<CustomersModel> findByPhoneNumber(String phoneNumber);
}
