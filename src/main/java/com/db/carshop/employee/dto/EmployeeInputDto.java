package com.db.carshop.employee.dto;

import com.db.carshop.employee.model.Type;
import com.db.carshop.person.Person;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class EmployeeInputDto extends Person {
    private String password;
    private Type type;
}
