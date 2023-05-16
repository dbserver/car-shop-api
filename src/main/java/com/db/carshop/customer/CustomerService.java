package com.db.carshop.customer;

import com.db.carshop.customer.dto.CustomerDto;
import com.db.carshop.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(CustomerDto dto);
    Customer updateCustomer(CustomerDto dto, Long id);
    Customer getById(Long id);
    List<Customer> getAll();
    void deleteById(Long id);
}
