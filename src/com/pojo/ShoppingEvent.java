package com;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pojo.Item;
import com.pojo.Shop;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * <h1>ShoppingEvent Class</h1>
 * <p>The class represents a shopping event. A single event where an individual goes to a store and buys different items.</p>
 *
 * @author Karmjit
 * @peer_reviewed_by: Benjamin
 * @version 1.0
 * @since 12-11-2018
 */
public class ShoppingEvent implements Serializable {

   private Shop shop;
   private ArrayList<Item> items;
   private LocalDateTime dateTime;

    /**
     * Converts the object into a Json object
     *
     * @return Json in string format, representing the Item object.
     */
   public String toJson(){
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      return gson.toJson(this);
   }

    /**
     *
     * @param shoppingEvent Object to compare with.
     * @return Boolean value. True if all ShoppingEvent attributes match.
     */
   public boolean equals(ShoppingEvent shoppingEvent){
      return false;
   }

   @Override
   public String toString(){
      return ("Shop: " + shop.name() + " at " + shop.getLocation() + "." + items.toString() + "Time: " + dateTime.toString());
   }

   // Sets current date and time.
   public ShoppingEvent(Shop shop, ArrayList<Item> items) {
      this.shop = shop;
      this.items = items;
      this.dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
   }

   // Accepts LocalDateTime object.
   public ShoppingEvent(Shop shop, ArrayList<Item> items, LocalDateTime dateTime) {
     this.shop = shop;
     this.items = items;
     this.dateTime = dateTime;
   }

   public Shop getShop() {
      return shop;
   }

   public void setShop(Shop shop) {
      this.shop = shop;
   }

   public ArrayList<Item> getItems() {
      return items;
   }

   public void setItems(ArrayList<Item> items) throws IllegalArgumentException{
      if(items.isEmpty()) throw new IllegalArgumentException("Lngth of items: 0. No items bought.");
      this.items = items;
   }

   public LocalDateTime getDateTime() {
      return dateTime;
   }

   public void setDateTime(LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }
}
