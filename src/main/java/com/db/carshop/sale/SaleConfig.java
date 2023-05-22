package com.db.carshop.sale;


import com.db.carshop.car.CarService;
import com.db.carshop.customer.CustomerService;
import com.db.carshop.employee.EmployeeService;
import com.db.carshop.sale.impl.SaleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class SaleConfig {
    @Bean
    public SaleService saleService(SaleRepository repository,
                                   CarService carService,
                                   EmployeeService employeeService,
                                   CustomerService customerService) {
        return new SaleServiceImpl(repository, carService, employeeService, customerService);
    }
}
