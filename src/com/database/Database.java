package com.database;

import com.pojo.ShoppingEvent;

import java.util.List;

public interface Database {

    ShoppingEvent get();

    List<ShoppingEvent> getAll();

    void append(ShoppingEvent eventToAdd);

    void delete(ShoppingEvent eventToDelete);

    void update(ShoppingEvent eventToUpdate, ShoppingEvent updatedEvent);

    void commit();

}