package com.pojo;

import com.converters.ParserVisitor;

import java.io.Serializable;

public enum Category implements BudgettingVisitableElement, Serializable {

    FOOD, LAUNDARY, HYGENE, ENTERTAINMENT, OTHER;

	@Override
	public Object stringParse(ParserVisitor converter, String recordStr) {
		return converter.visitElement(this, recordStr);
	}
}
