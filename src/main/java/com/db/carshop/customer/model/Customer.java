package com.db.carshop.customer.model;

import com.db.carshop.car.model.Car;
import com.db.carshop.person.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
@SuperBuilder
public class Customer extends Person {
}
