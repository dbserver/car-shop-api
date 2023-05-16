package com.db.carshop.employee.dto;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeOutputDto  {
    private Long id;
    private String name;
    private String email;
    private Long storeId;
}
