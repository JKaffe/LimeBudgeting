package com.database.csv;

import java.util.HashMap;
import java.util.Map;

public class CsvSchema {

	public static final CsvColumn[] DEFAULT_COLUMN_ORDER = {CsvColumn.SHOP, CsvColumn.ITEM_NAME, CsvColumn.PRICE, CsvColumn.CATEGORY, CsvColumn.TIME};
	public static final Map<CsvColumn, Integer> DEFAULT_SCHEMA = getDefaultSchema();

	private static CsvSchema singletonCsvSchema = null;
	private final Map<CsvColumn, Integer> schema;

	private CsvSchema(Map<CsvColumn, Integer> schema) throws IllegalArgumentException{
		if(schema.size() != CsvColumn.values().length){
			throw new IllegalArgumentException();
		}
		this.schema = schema;
	}

	private static Map<CsvColumn, Integer> getDefaultSchema(){
		final Map<CsvColumn, Integer> map = new HashMap<>();

		for(int columnNum = 0; columnNum < DEFAULT_COLUMN_ORDER.length; columnNum++){
			map.put(DEFAULT_COLUMN_ORDER[columnNum], columnNum);
		}

		return map;
	}

	public static CsvSchema getInstance(Map<CsvColumn, Integer> schema) throws IllegalArgumentException{
		if(singletonCsvSchema == null){
			singletonCsvSchema = new CsvSchema(schema);
			return singletonCsvSchema;
		} else {
			System.out.println("WARNING: CsvSchema already exists. Passing existing instance.");
			return singletonCsvSchema;
		}
	}

	public Integer getPointer(CsvColumn column){
		return schema.get(column);
	}

	public Integer size(){
		return schema.size();
	}

	@Override
	public String toString() {
		return schema.toString();
	}
}
