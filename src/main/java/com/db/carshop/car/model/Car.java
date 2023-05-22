package com.db.carshop.car.model;

import com.db.carshop.sale.model.Sale;
import com.db.carshop.store.model.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String licensePlate;
    private String color;
    private String kmPerHour;
    private Fuel fuel;
    private NumberPassengers numberPassengers;
    private Additional additional;
    private Boolean available;

    @ManyToOne
    @JsonIgnore
    private Store store;

    @OneToOne(mappedBy = "car")
    @JsonIgnore
    private Sale sale;
}
