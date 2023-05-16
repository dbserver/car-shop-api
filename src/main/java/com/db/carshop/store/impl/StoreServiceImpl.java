package com.db.carshop.store.impl;

import com.db.carshop.store.StoreMapper;
import com.db.carshop.store.StoreRepository;
import com.db.carshop.store.StoreService;
import com.db.carshop.store.dto.StoreDto;
import com.db.carshop.store.exception.StoreDoesNotExistException;
import com.db.carshop.store.model.Store;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StoreServiceImpl implements StoreService {
    private StoreRepository repository;
    private StoreMapper mapper;

    @Override
    public Store createStore(StoreDto storeDto) {
        Store store = Store.builder()
                .name(storeDto.getName())
                .build();
        return repository.save(store);
    }

    @Override
    public Store updateStore(StoreDto storeDto, Long id) {
        Store store = findById(id);
        mapper.updateMapperFromDto(storeDto, store);

        return repository.save(store);
    }

    @Override
    public Store findById(Long id) {
        return repository.findById(id)
                .orElseThrow(StoreDoesNotExistException::new);
    }

    @Override
    public List<Store> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new StoreDoesNotExistException();
        }
        repository.deleteById(id);
    }
}
