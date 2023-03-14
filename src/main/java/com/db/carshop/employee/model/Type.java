package com.db.carshop.employee.model;

public enum Type {
    SELLER("SELLER"),
    BUYER("BUYER"),
    PREMIUM("PREMIUM"),
    MANAGER("MANAGER");

    private final String code;

    Type(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
