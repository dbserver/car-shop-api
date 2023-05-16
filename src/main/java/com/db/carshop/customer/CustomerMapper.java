package com.db.carshop.customer;

import com.db.carshop.customer.dto.CustomerDto;
import com.db.carshop.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CustomerMapper {
    void updateCustomerFromDto(CustomerDto dto, @MappingTarget Customer customer);
}
