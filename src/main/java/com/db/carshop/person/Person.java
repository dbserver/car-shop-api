package com.db.carshop.person;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private String email;
    private String address;
    private String phone;
    private String cpf;
}
