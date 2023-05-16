package com.db.carshop.sale;

import com.db.carshop.sale.dto.SaleDto;
import com.db.carshop.sale.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SaleMapper {
    void updateSaleFromDto(SaleDto dto, @MappingTarget Sale sale);
}
