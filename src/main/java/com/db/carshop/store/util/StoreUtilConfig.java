package com.db.carshop.store.util;

import com.db.carshop.store.StoreRepository;
import com.db.carshop.store.util.impl.StoreUtilImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class StoreUtilConfig {
    @Bean
    public StoreUtil storeUtil(StoreRepository repository) {
        return new StoreUtilImpl(repository);
    }
}
