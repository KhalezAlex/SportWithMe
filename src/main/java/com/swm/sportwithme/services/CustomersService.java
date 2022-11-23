package com.swm.sportwithme.services;

import com.swm.sportwithme.models.CustomersModel;
import com.swm.sportwithme.reposiotries.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomersService {
    private CustomerRepository customerRepository;

    public CustomersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomersModel registerCustomer(String login, String phone) {
        if (login.equals("") && phone.equals("")) return null;
        else {
            if (customerRepository.findByLogin(login).isPresent() ||
                    customerRepository.findByPhoneNumber(phone).isPresent()) {
                System.out.println("duplicate login (phone)");
                return null;
            }
            return customerRepository.save(new CustomersModel(login, phone));
        }
    }

    public boolean checkLogin(String login) {
        return customerRepository.findByLogin(login).isPresent();
    }

    public boolean checkPhone(String phone) {
        return customerRepository.findByPhoneNumber(phone).isPresent();
    }

    public CustomersModel findCustomerByLogin(String login) {
        return customerRepository.findByLogin(login).orElse(null);
    }

    public CustomersModel findCustomerByPhone(String phone) {
        return customerRepository.findByPhoneNumber(phone).orElse(null);
    }
}
