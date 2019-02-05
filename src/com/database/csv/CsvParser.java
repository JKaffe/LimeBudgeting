package com.database.csv;

import com.database.ParserVisitor;
import com.database.csv.CsvValueMapper;
import com.database.csv.CsvColumn;
import com.pojo.*;
import com.pojo.traites.ParsableElement;

public final class CsvParser implements ParserVisitor {

	final public static char LIST_SEPARATOR = '.';
	final public static char DATE_SEPARATOR = '/';
	final public static char COMMA_SEPARATOR = ',';

	/*
	@Override
	public void visitElement(Category obj, String value) {
		try{
		} catch(IllegalArgumentException | NullPointerException valueNotParsable){
			System.out.println("Parsing Error: Could not parse value: " + value + " with enum Category.");
			System.out.println("Returning null.");
			ParseVisitor visitor = new CsvParser()
			obj = null;
		}
	}
	*/

	@Override
	public void visitElement(Item obj, String value) {
		CsvValueMapper valueMapper = new CsvValueMapper(value);

		obj.setName(valueMapper.get(CsvColumn.ITEM_NAME));
		obj.setCategory(Category.valueOf(valueMapper.get(CsvColumn.CATEGORY)));
		obj.setPrice(Double.parseDouble(valueMapper.get(CsvColumn.PRICE)));
	}

	/*
	@Override
	public void visitElement(Shop obj, String value) {
		try{
			Shop.valueOf(value);
		} catch(IllegalArgumentException | NullPointerException valueNotParsable){
			System.out.println("Parsing Error: Could not parse value: " + value + " with enum Shop.");
			System.out.println("Returning null.");
		}
	}
	*/

	@Override
	public void visitElement(ShoppingEvent obj, String value) {
	}

}
