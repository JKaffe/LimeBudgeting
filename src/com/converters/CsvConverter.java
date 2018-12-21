package com.converters;

public interface CsvConverter {

	Object convert(String record);

	String convertToWrite(Object obj);

}
