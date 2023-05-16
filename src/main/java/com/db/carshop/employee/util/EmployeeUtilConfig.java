package com.db.carshop.employee.util;

import com.db.carshop.employee.util.impl.EmployeeUtilImpl;
import com.db.carshop.store.StoreService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableJpaRepositories
public class EmployeeUtilConfig {
    @Bean
    public EmployeeUtil employeeUtil(StoreService storeService, PasswordEncoder passwordEncoder) {
        return new EmployeeUtilImpl(storeService, passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
