package com.db.carshop.employee;


import com.db.carshop.employee.impl.EmployeeServiceImpl;
import com.db.carshop.employee.util.EmployeeUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class EmployeeConfig {
    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository,
                                           EmployeeUtil util, EmployeeMapper mapper) {
        return new EmployeeServiceImpl(employeeRepository, util, mapper);
    }
}
