package com.db.carshop.store.model;

import com.db.carshop.car.model.Car;
import com.db.carshop.employee.model.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "store")
    private List<Car> cars;

    @OneToMany(mappedBy = "store")
    private List<Employee> employees;

}
