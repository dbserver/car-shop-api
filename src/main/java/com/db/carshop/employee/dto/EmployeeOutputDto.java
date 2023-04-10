package com.db.carshop.employee.dto;

import com.db.carshop.employee.model.Type;
import com.db.carshop.person.Person;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeOutputDto extends Person {
    private Long id;
    private Type type;
}
