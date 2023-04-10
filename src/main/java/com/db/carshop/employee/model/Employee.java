package com.db.carshop.employee.model;

import com.db.carshop.person.Person;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class Employee extends Person {
    private Long id;
    private String password;
    private Type type;

}
