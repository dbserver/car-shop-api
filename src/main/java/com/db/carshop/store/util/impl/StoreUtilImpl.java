package com.db.carshop.store.util.impl;

import com.db.carshop.store.StoreRepository;
import com.db.carshop.store.exception.StoreDoesNotExistException;
import com.db.carshop.store.model.Store;
import com.db.carshop.store.util.StoreUtil;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class StoreUtilImpl implements StoreUtil {
    private StoreRepository repository;

    public Store createFirstStoreIfNotExist(){
        Store store = Store.builder()
                .name("Loja1")
                .build();

        return findByIdWithoutThrow(1l)
                .orElse(repository.save(store));
    }

    public Optional<Store> findByIdWithoutThrow(Long id) {
        return repository.findById(id);
    }

    public Store getStore(Long id){
        if(id == null){
            return createFirstStoreIfNotExist();
        }
        return repository.findById(id)
                .orElseThrow(StoreDoesNotExistException::new);
    }
}
