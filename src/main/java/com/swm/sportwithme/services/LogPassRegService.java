package com.swm.sportwithme.services;

import com.swm.sportwithme.models.CustomersModel;
import com.swm.sportwithme.models.LogPassModel;
import com.swm.sportwithme.reposiotries.CustomerRepository;
import com.swm.sportwithme.reposiotries.LogPassRepository;
import org.springframework.stereotype.Service;

@Service
public class LogPassRegService {
    private final LogPassRepository logPassRepository;

    private final CustomerRepository customerRepository;

    public LogPassRegService(LogPassRepository logPassRepository, CustomerRepository customerRepository) {
        this.logPassRepository = logPassRepository;
        this.customerRepository = customerRepository;
    }

    public LogPassModel registerUser(String logPassHash, String phonePassHash, CustomersModel customerId) {
        if (logPassHash == null && phonePassHash == null) {
            return null;
        }
        else {
//            if (usersRepository.findFirstByLogin(login).isPresent()) {
//                System.out.println("duplicate login");
//                return null;
//            }
            LogPassModel logPassModel = new LogPassModel();
            logPassModel.setLogPassHash(logPassHash);
            logPassModel.setPhonePassHash(phonePassHash);
            logPassModel.setCustomerId(customerId);
            return logPassRepository.save(logPassModel);
        }
    }

    public LogPassModel authenticate(String logPhonePassHash, boolean isLogin) {
        if(isLogin)
            return logPassRepository.findByLogPassHash(logPhonePassHash).orElse(null);
        else
            return logPassRepository.findByPhonePassHash(logPhonePassHash).orElse(null);
    }

}
