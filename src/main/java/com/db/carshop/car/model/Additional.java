package com.db.carshop.car.model;

public enum Additional {
    AIR_CONDITIONING("AIR CONDITIONING"),
    ELECTRIC_LOCKS("ELECTRIC_LOCKS"),
    STEREO("STEREO"),
    POWER_STEERING("POWER_STEERING");

    private final String code;

    Additional(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
