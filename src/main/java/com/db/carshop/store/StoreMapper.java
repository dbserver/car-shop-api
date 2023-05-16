package com.db.carshop.store;

import com.db.carshop.store.dto.StoreDto;
import com.db.carshop.store.model.Store;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface StoreMapper {
    void updateMapperFromDto(StoreDto dto, @MappingTarget Store store);
}
