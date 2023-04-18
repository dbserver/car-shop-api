package com.db.carshop.employee.model;

import com.db.carshop.car.model.Car;
import com.db.carshop.person.Person;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "employee")
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private Type type;

    @OneToMany(mappedBy = "employeeBought")
    private List<Car> boughtCars;

    @OneToMany(mappedBy = "employeeSold")
    private List<Car> soldCars;
}
