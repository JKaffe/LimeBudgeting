/*package com.converters;

import com.pojo.BudgettingVisitableElement;
import com.pojo.Item;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class CsvItemParser extends CsvParser {

	public Map<String, String> genNameToValueMap(String[] fieldNames, String[] values) throws IllegalArgumentException {
		if(fieldNames.length != values.length){
			final String errorMsg = "ERROR Number of fields and given values do not match.\nFields ->  "
					+ fieldNames.toString() + "\nValues -> " + values.toString();
			throw new IllegalArgumentException(errorMsg);
		}

		final Map<String, String> map = new HashMap<>();

		for(int k = 0; k < fieldNames.length; k++){
			map.put(fieldNames[k], values[k]);
		}

		return map;
	}


	@Override
	public Object parse(String record, BudgettingVisitableElement pojoObj, BudgetingConverter converter) throws ParseException {
		final String[] values = record.split(String.valueOf(COMMA_SEPARATOR));
		return converter.convertValuesToParam(values, pojoObj);


		/*
		final int EXPECTED_COLUMNS = this.getNumToColumnNameMap().size();
		if (values.length != EXPECTED_COLUMNS) {
			final String errorMsg = "Invalid Csv input. Expected: " + EXPECTED_COLUMNS + " fields but received: " + fields.length;
			throw new ParseException(errorMsg, record.length());
		}

		final AbstractClassMapper mapper = new ItemClassMapper();
		final String[] fieldNames = getNumToColumnNameMap().values().toArray(new String[getNumToColumnNameMap().size()]);
		final Map<String, String> map = genNameToValueMap(fieldNames, values);


		try {
			Constructor<Item> constructor = Item.class.getConstructor(String.class, Double.class, Category.class);
			// constructor.newInstance()
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		*/

		/*
		for (int currentColumn = 0; currentColumn <= EXPECTED_COLUMNS - 1; currentColumn++) {
			final String value = fields[currentColumn];
			final String columnName = this.getNumToColumnNameMap().get(currentColumn);
			System.out.println(columnName);
			final Class classRequired = this.getColumnNameToClassMap().get(columnName);
			final Object convertedValue = this.typeConverter(value);
			final AbstractClassMapper mapper = new ItemClassMapper();

			System.out.println("Value: " + convertedValue + " instance of: " + convertedValue.getClass() + ".");
			System.out.println(classRequired);
			if (classRequired.isInstance(convertedValue)) {
				// Here if the data type is correct.
				try {
					mapper.getSetterFor(Item.class.getField(columnName)).invoke(item, convertedValue);
				} catch (NoSuchMethodException noMethodE) {
					final String errorMsg = "ERROR: Could not find method: " + "set" + columnName + " in class " + convertedValue.getClass();
					throw new ParseException(errorMsg, 0);
				} catch (InvocationTargetException objError) {
					System.out.println("Class: " + item.getClass().toString() + ". Error");
					objError.printStackTrace();
				} catch (IllegalAccessException accessError) {
					System.out.println("Cannot access method: " + "set" + columnName + " in class: " + Item.class.toString());
					accessError.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
			} else {
				final String errorMsg = "ERROR: Incorrect Data Type for value: " + convertedValue
						+ " . Expected : " + classRequired.toString() + " but received: " + convertedValue.getClass();

				//Adjust Offset*************************************************************
				//Will involve incrementor of the for loop
				throw new ParseException(errorMsg, 0);
			}
		}
		*/
/*
		return item;

	}

	@Override
	/*DO ERROR HANDELING******************************************************//*
	public String convertToWrite(Object obj) {
		final Field[] fields = Item.class.getFields();
		final StringBuilder csvLine = new StringBuilder();

		this.getNumToColumnNameMap().keySet().stream().sequential().sorted().forEachOrdered((Integer columnNumber) -> {
			final String columnName = this.getNumToColumnNameMap().get(columnNumber);
			try {
				csvLine.append((String) Item.class.getMethod("get" + columnName, Item.class).invoke(obj) + COMMA_SEPARATOR);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		});

		System.out.println("PRODUCED CSV LINE: \n" + csvLine.toString());

		return csvLine.toString();
	}
}
*/
