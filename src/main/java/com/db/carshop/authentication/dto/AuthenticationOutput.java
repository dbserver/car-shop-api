package com.db.carshop.authentication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationOutput {
    private String token;

    public AuthenticationOutput(String token) {
        this.token = token;
    }
}
