package com.database.csv;

import java.util.HashMap;
import java.util.Map;

public final class CsvValueMapper {

	private final CsvSchema schema;
	private final String[] recordValues;
	private final Map<CsvColumn, String> mappings;

	public CsvValueMapper(String record) throws IllegalArgumentException{
		this(record, CsvSchema.getInstance(CsvSchema.DEFAULT_SCHEMA));
	}

	public CsvValueMapper(String record, CsvSchema schema) throws IllegalArgumentException{
		this.recordValues = record.split(",");
		this.schema = schema;

		final int EXPECTED_COLUMNS = schema.size();
		final int RECEIVED_COLUMNS = recordValues.length;
		if(RECEIVED_COLUMNS != EXPECTED_COLUMNS){
			final String errorMsg = "ERROR: Received record cannot be parsed with schema. " +
					"Expected: " + EXPECTED_COLUMNS	+ " columns but received: " + RECEIVED_COLUMNS + " columns." +
					"Record: " + record + "\nSchema: " + schema.toString();
			throw new IllegalArgumentException(errorMsg);
		}

		this.mappings = getMappings();
	}

	private Map<CsvColumn, String> getMappings() {
		final Map<CsvColumn, String> map = new HashMap<>();

		for(CsvColumn column : CsvColumn.values()){
			map.put(column, recordValues[schema.getPointer(column)]);
		}

		return map;
	}

	public String get(CsvColumn column){
		return this.mappings.get(column);
	}
}
