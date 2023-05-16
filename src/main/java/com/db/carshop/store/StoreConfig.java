package com.db.carshop.store;

import com.db.carshop.store.impl.StoreServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class StoreConfig {
    @Bean
    public StoreService StoreService(StoreRepository repository,
                                           StoreMapper mapper) {
        return new StoreServiceImpl(repository, mapper);
    }
}
