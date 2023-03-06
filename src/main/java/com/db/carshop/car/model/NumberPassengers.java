package com.db.carshop.car.model;

public enum NumberPassengers {
    ONE("ONE"),
    TWO("TWO"),
    THREE("THREE"),
    FOUR("FOUR"),
    SIX("SIX");

    private final String code;

    NumberPassengers(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
