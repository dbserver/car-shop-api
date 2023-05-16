package com.db.carshop.employee.dto;

import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInputDto {
    private String name;
    private String email;
    private String password;
    private Long storeId;
}
