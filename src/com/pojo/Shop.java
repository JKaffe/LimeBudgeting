package com.pojo;

import com.converters.ParserVisitor;

import java.io.Serializable;

public enum Shop  implements BudgettingVisitableElement, Serializable {

    LIDL("ONE") , ASDA("Mile End"), SAINSBURY("Mile End");

    private String location;

    Shop(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public Object stringParse(ParserVisitor converter, String recordStr) {
        return converter.visitElement(this, recordStr);
    }
}