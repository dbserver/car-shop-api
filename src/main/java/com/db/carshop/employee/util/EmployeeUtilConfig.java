package com.db.carshop.employee.util;

import com.db.carshop.employee.util.impl.EmployeeUtilImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class EmployeeUtilConfig {
    @Bean
    public EmployeeUtil employeeUtil() {
        return new EmployeeUtilImpl();
    }
}
