package com.db.carshop.employee.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInputDto {
    @NotNull(message = "Nome não pode ser nulo")
    private String name;

    @NotNull(message = "Email não pode ser nulo")
    @Email(message = "Preencha com um email válido")
    private String email;

    @NotNull(message = "Senha não pode ser nula")
    private String password;

    private Long storeId;
}
