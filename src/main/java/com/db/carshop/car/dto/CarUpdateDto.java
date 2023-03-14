package com.db.carshop.car.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class CarUpdateDto {
    private Long carId;
    private CarDto carDto;
}
