package com.db.carshop.store;

import com.db.carshop.store.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
