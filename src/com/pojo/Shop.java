package com.pojo;

import java.io.Serializable;

public enum Shop implements Serializable {

    LIDL("ONE") , ASDA("Mile End"), SAINSBURY("Mile End");

    private String location;

    Shop(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}