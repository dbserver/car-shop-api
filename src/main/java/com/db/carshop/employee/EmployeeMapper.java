package com.db.carshop.employee;

import com.db.carshop.car.dto.CarDto;
import com.db.carshop.car.model.Car;
import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface EmployeeMapper {
    void updateEmployeeFromDto(EmployeeInputDto dto, @MappingTarget Employee employee);
}
