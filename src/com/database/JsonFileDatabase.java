package com.database;

import com.FileHandler;
import com.ShoppingEvent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonFileDatabase implements Database{

    private boolean autoCommit = false;

    private final String databaseFileName;
    private List<ShoppingEvent> shoppingEvents;

    public JsonFileDatabase(String databaseFileName) throws InvalidPathException, IOException {
        this.databaseFileName = databaseFileName;
        this.shoppingEvents = this.getAllShoppingEvents();
    }

    public JsonFileDatabase(String databaseFileName, boolean autoCommit) throws InvalidPathException, IOException {
        this.autoCommit = autoCommit;
        this.databaseFileName = databaseFileName;
        this.shoppingEvents = this.getAllShoppingEvents();
    }

    private List<ShoppingEvent> getAllShoppingEvents() throws InvalidPathException, IOException{
        Gson gson = new Gson();
        try{
            final String json = FileHandler.getString(this.databaseFileName);
            return gson.fromJson(json, new TypeToken<ArrayList<ShoppingEvent>>() {}.getType());
        } catch(InvalidPathException e0){
            System.out.println("ERROR: Problem with path. " + this.databaseFileName);
            throw e0;
        } catch(IOException e1){
            final String eMsg = "IO ERROR. File: " + this.databaseFileName;
            e1.printStackTrace();
            System.out.println(eMsg);
            throw new IOException(eMsg + "\n" + e1.getMessage());
        }
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    private void autoCommitIfEnabled(){
        if(this.autoCommit) commit();
    }

    @Override
    public List<ShoppingEvent> getShoppingEvents() {
        return null;
    }

    @Override
    public void append(ShoppingEvent eventToAdd) {
        shoppingEvents.add(eventToAdd);
        autoCommitIfEnabled();
    }

    @Override
    public void delete(ShoppingEvent eventToDelete) {
        this.shoppingEvents.removeAll(Collections.singleton(eventToDelete));
    }

    @Override
    public void update(ShoppingEvent eventToUpdate, ShoppingEvent updatedEvent) {

    }

    @Override
    public void commit() {

    }

}
