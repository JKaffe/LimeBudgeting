package com.database;

import com.pojo.ShoppingEvent;

import java.util.ArrayList;
import java.util.List;

public class BudgetingDatabase implements Database{

    protected boolean autoCommit = false;
    protected final String databaseFileName;
    protected final List<ShoppingEvent> shoppingEvents;
    protected final DatabaseImplementation databaseImplementation;

    public BudgetingDatabase(String databaseFileName, DatabaseImplementation databaseImplementation) {
        this.databaseFileName = databaseFileName;
        this.databaseImplementation = databaseImplementation;
        this.shoppingEvents = this.databaseImplementation.getShoppingEventsFromDatabase(this.databaseFileName);
    }

    public BudgetingDatabase(String databaseFileName, DatabaseImplementation databaseImplementation, boolean autoCommit){
        this.databaseFileName = databaseFileName;
        this.databaseImplementation = databaseImplementation;
        this.shoppingEvents = this.databaseImplementation.getShoppingEventsFromDatabase(this.databaseFileName);
        this.autoCommit = autoCommit;
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public String getDatabaseFileName() {
        return databaseFileName;
    }

    public List<ShoppingEvent> getShoppingEvents() {
        return shoppingEvents;
    }

    @Override
    public ShoppingEvent get() {
        return null;
    }

    @Override
    public List<ShoppingEvent> getAll() {
        return new ArrayList<ShoppingEvent>(this.shoppingEvents);
    }

    @Override
    public void append(ShoppingEvent eventToAdd) {
        this.shoppingEvents.add(eventToAdd);
    }

    @Override
    public void delete(ShoppingEvent eventToDelete) {
        this.shoppingEvents.remove(eventToDelete);
    }

    @Override
    public void update(ShoppingEvent eventToUpdate, ShoppingEvent updatedEvent) {

    }

    @Override
    public void commit() {
        this.databaseImplementation.commitShoppingEventsToDatabase(this.databaseFileName, this.shoppingEvents);
    }
}
