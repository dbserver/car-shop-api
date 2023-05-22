package com.db.carshop.store;

import com.db.carshop.store.dto.StoreDto;
import com.db.carshop.store.model.Store;


import java.util.List;
import java.util.Optional;

public interface StoreService {
    Store createStore(StoreDto storeDto);
    Store updateStore(StoreDto storeDto, Long id);
    Store findById(Long id);
    List<Store> getAll();
    void deleteById(Long id);
}
