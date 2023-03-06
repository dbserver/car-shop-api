package com.db.carshop.car.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(name = "foster_next_visit")
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

}
