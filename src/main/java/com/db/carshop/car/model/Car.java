package com.db.carshop.car.model;


import com.db.carshop.employee.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
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
    private Employee employeeBought;

    @ManyToOne
    @JsonIgnore
    private Employee employeeSold;
}
