package com.db.carshop.customer.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class CustomerDto {
    private String name;
    private String cpf;
}
