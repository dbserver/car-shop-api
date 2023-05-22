package com.db.carshop.customer.impl;

import com.db.carshop.customer.CustomerMapper;
import com.db.carshop.customer.CustomerRepository;
import com.db.carshop.customer.CustomerService;
import com.db.carshop.customer.dto.CustomerDto;
import com.db.carshop.customer.exceptions.CustomerAlreadyExistsException;
import com.db.carshop.customer.exceptions.CustomerDoesNotExistException;
import com.db.carshop.customer.model.Customer;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository repository;
    private CustomerMapper customerMapper;

    @Override
    public Customer createCustomer(CustomerDto dto) {
        verifyIfCpfAlreadyExists(dto.getCpf());

        Customer customer = Customer.builder()
                .name(dto.getName())
                .cpf(dto.getCpf())
                .build();
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(CustomerDto dto, Long id) {
        Customer customer = getById(id);
        verifyIfCpfAlreadyExistsInUpdate(id, dto.getCpf());

        customerMapper.updateCustomerFromDto(dto, customer);
        return repository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return repository.findById(id)
                .orElseThrow(CustomerDoesNotExistException::new);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new CustomerDoesNotExistException();
        }
        repository.deleteById(id);
    }

    private void verifyIfCpfAlreadyExists(String cpf) {
        if (repository.findByCpf(cpf).isPresent()) {
            throw new CustomerAlreadyExistsException();
        }
    }

    private void verifyIfCpfAlreadyExistsInUpdate(Long customerId, String cpf) {
        Customer customerOfDTO= repository.findByCpf(cpf)
                .orElse(null);

        if(customerOfDTO!= null &&
                !customerOfDTO.getId().equals(customerId)){
            throw new CustomerAlreadyExistsException();
        }
    }
}