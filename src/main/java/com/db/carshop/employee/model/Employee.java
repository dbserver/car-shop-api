package com.db.carshop.employee.model;

import com.db.carshop.sale.model.Sale;
import com.db.carshop.user.User;
import com.db.carshop.store.model.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JsonIgnore
    private List<Sale> sales;

    @ManyToOne
    @JsonIgnore
    private Store store;

}
