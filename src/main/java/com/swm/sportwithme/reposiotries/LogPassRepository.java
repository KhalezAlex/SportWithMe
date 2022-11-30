package com.swm.sportwithme.reposiotries;

import com.swm.sportwithme.models.CustomersModel;
import com.swm.sportwithme.models.LogPassModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LogPassRepository extends JpaRepository<LogPassModel, Long> {

    Optional<LogPassModel> findByLogPassHash(String logPassHash);

    Optional<LogPassModel> findByPhonePassHash(String phonePassHash);

    Optional<LogPassModel> findFirstByCustomerId(CustomersModel customersModel);
}
