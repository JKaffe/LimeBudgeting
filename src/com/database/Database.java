package com.database;

import com.*;

import java.util.List;

public interface Database{

    List<ShoppingEvent> getShoppingEvents();

    void append(ShoppingEvent eventToAdd);

    void delete(ShoppingEvent eventToDelete);

    void update(ShoppingEvent eventToUpdate, ShoppingEvent updatedEvent);

    void commit();

}