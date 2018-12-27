package com.converters;

import com.pojo.BudgettingVisitableElement;

import java.text.ParseException;

public abstract class CsvConverter {

	final public char LIST_SEPARATOR = '.';
	final public char DATE_SEPARATOR = '/';
	final public char COMMA_SEPARATOR = ',';

	public Object parse(String record, BudgettingVisitableElement pojoObj, ParserVisitor converter) throws ParseException{
		return null;
	}

	public String convertToWrite(Object obj){
		return null;
	}

}
