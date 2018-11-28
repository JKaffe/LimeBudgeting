package com.pojo;

public enum Shop {

    LIDL("ONE") , ASDA("Mile End"), SAINSBURY("Mile End");

    private String location;

    Shop(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}