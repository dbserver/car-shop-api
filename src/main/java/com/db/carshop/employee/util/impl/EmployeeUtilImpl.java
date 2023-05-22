package com.db.carshop.employee.util.impl;

import com.db.carshop.employee.dto.EmployeeInputDto;
import com.db.carshop.employee.dto.EmployeeOutputDto;
import com.db.carshop.employee.model.Employee;
import com.db.carshop.employee.util.EmployeeUtil;
import com.db.carshop.store.util.StoreUtil;
import com.db.carshop.user.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


@AllArgsConstructor
public class EmployeeUtilImpl implements EmployeeUtil {
    private StoreUtil storeUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Employee inputDtoToEmployee(EmployeeInputDto inputDto) {

        User user = User.builder()
                .email(inputDto.getEmail())
                .password(passwordEncoder.encode(inputDto.getPassword()))
                .build();

        return  Employee.builder()
                .name(inputDto.getName())
                .user(user)
                .store(storeUtil.getStore(inputDto.getStoreId()))
                .build();
    }

    @Override
    public EmployeeOutputDto employeeToOutputDto(Employee employee) {

        return EmployeeOutputDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getUser().getEmail())
                .storeId(employee.getStore().getId())
                .build();
    }

}
