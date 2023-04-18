package com.db.carshop.employee.dto;

import com.db.carshop.car.model.Car;
import com.db.carshop.employee.model.Type;
import com.db.carshop.person.Person;
import lombok.*;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeOutputDto extends Person {
    private Long id;
    private Type type;
    @OneToMany(mappedBy = "employeeBought")
    private List<Car> boughtCars;

    @OneToMany(mappedBy = "employeeSold")
    private List<Car> carsSold;
}
