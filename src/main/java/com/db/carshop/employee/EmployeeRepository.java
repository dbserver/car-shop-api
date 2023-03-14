package com.db.carshop.employee;

import com.db.carshop.car.model.Car;
import com.db.carshop.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
