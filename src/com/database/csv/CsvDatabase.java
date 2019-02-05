package com.database.csv;

import com.database.DatabaseImplementation;
import com.pojo.ShoppingEvent;

import java.util.ArrayList;
import java.util.List;

public class CsvDatabase implements DatabaseImplementation {

	@Override
	public List<ShoppingEvent> getShoppingEventsFromDatabase(String fileName) {
		return new ArrayList<ShoppingEvent>();
	}

	@Override
	public void commitShoppingEventsToDatabase(String fileName, List<ShoppingEvent> shoppingEvents) {

	}
}
