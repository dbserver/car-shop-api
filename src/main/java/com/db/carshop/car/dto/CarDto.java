package com.db.carshop.car.dto;

import com.db.carshop.car.model.Additional;
import com.db.carshop.car.model.Fuel;
import com.db.carshop.car.model.NumberPassengers;
import com.db.carshop.employee.model.Employee;
import lombok.*;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@EqualsAndHashCode
public class CarDto {
    private String brand;
    private String model;
    private String licensePlate;
    private String color;
    private String kmPerHour;
    private Fuel fuel;
    private NumberPassengers numberPassengers;
    private Additional additional;
}
