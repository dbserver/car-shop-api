package com.db.carshop.car.model;

public enum Fuel {
    REGULAR_GASOLINE("REGULAR GASOLINE"),
    GASOLINE_WITH_ADDITIVES("GASOLINE WITH ADDITIVES"),
    PREMIUM_GASOLINE("PREMIUM GASOLINE"),
    FORMULATED_GASOLINE("FORMULATED GASOLINE"),
    ETHANOL("ETHANOL"),
    ETHANOL_WITH_ADDITIVES("ETHANOL WITH ADDITIVES"),
    VEHICULAR_NATURAL_GAS("VEHICULAR NATURAL GAS"),
    DIESEL("DIESEL");

    private final String code;

    Fuel(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
