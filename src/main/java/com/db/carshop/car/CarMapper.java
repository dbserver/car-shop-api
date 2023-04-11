package com.db.carshop.car;

import com.db.carshop.car.dto.CarDto;
import com.db.carshop.car.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CarMapper {
    void updateCarFromDto(CarDto dto, @MappingTarget Car car);
}
