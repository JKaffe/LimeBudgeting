package com.database;

import com.pojo.ShoppingEvent;

import java.util.List;

public interface DatabaseImplementation {

    List<ShoppingEvent> getShoppingEventsFromDatabase(String fileName);

    void commitShoppingEventsToDatabase(String fileName, List<ShoppingEvent> shoppingEvents);

}
