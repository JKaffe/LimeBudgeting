package com.converters;

import com.pojo.*;

public abstract class CsvParser implements ParserVisitor {

	final public char LIST_SEPARATOR = '.';
	final public char DATE_SEPARATOR = '/';
	final public char COMMA_SEPARATOR = ',';

	@Override
	public Object visitElement(Category obj, String value) {
		return null;
	}

	@Override
	public Object visitElement(Item obj, String value) {
		return null;
	}

	@Override
	public Object visitElement(Shop obj, String value) {
		return null;
	}

	@Override
	public Object visitElement(ShoppingEvent obj, String value) {
		return null;
	}
}
