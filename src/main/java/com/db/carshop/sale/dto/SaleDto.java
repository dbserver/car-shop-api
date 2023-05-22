package com.db.carshop.sale.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class SaleDto {
    private Long carId;
    private Long customerId;
    private Long employeeId;
}
