package com.db.carshop.customer;

import com.db.carshop.customer.impl.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class CustomerConfig {
    @Bean
    public CustomerService customerService(CustomerRepository repository,
                                           CustomerMapper mapper) {
        return new CustomerServiceImpl(repository, mapper);
    }
}
