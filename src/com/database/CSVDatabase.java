package com.database;

import com.pojo.ShoppingEvent;

import java.util.ArrayList;
import java.util.List;

public class CSVDatabase implements DatabaseImplementation {

	@Override
	public List<ShoppingEvent> getShoppingEventsFromDatabase(String fileName) {
		return new ArrayList<ShoppingEvent>();
	}

	@Override
	public void commitShoppingEventsToDatabase(String fileName, List<ShoppingEvent> shoppingEvents) {

	}
}
