package com.database;

import com.ShoppingEvent;

import java.util.List;

class BurgetingDatabase {

    private boolean autoCommit = false;
    private final String databaseFileName;
    private final List<ShoppingEvent> shoppingEvents;
    private final Database database;

    public BurgetingDatabase(String databaseFileName, List<ShoppingEvent> shoppingEvents, Database database) {
        this.databaseFileName = databaseFileName;
        this.shoppingEvents = shoppingEvents;
        this.database = database;
    }

    public BurgetingDatabase(boolean autoCommit, String databaseFileName, List<ShoppingEvent> shoppingEvents, Database database){
        this.autoCommit = autoCommit;
        this.databaseFileName = databaseFileName;
        this.shoppingEvents = shoppingEvents;
        this.database = database;
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
}
