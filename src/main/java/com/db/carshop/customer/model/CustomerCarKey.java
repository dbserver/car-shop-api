package com.db.carshop.customer.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCarKey implements Serializable {
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "car_id")
    private Long carId;
}
