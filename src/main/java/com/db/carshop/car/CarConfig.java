package com.db.carshop.car;

import com.db.carshop.car.impl.CarServiceImpl;
import com.db.carshop.store.StoreService;
import com.db.carshop.store.util.StoreUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class CarConfig {
    @Bean
    public CarService carService(CarRepository carRepository,
                                 CarMapper mapper,
                                 StoreUtil storeUtil) {
        return new CarServiceImpl(carRepository, mapper, storeUtil);
    }
}
