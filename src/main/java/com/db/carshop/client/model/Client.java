package com.db.carshop.client.model;

import com.db.carshop.car.model.Car;
import com.db.carshop.person.Person;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(name = "client")
public class Client extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Car> carsSold;
    private List<Car> boughtCars;
}
