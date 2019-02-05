package com.pojo;

import com.database.ParserVisitor;
import com.pojo.traites.ParsableElement;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>ShoppingEvent Class</h1>
 * <p>The class represents a shopping event. A single event where an individual goes to a store and buys different items.</p>
 *
 * @author Karmjit
 * @peer_reviewed_by: Benjamin
 * @version 1.0
 * @since 12-11-2018
 */
public final class ShoppingEvent implements CompositePojo, ParsableElement, Serializable {

	private Shop shop;
	private List<Item> items;
	private LocalDateTime dateTime;

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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public LocalDateTime getDateTime() {
	  return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString(){
		return ("Shop: " + shop.name() + " at " + shop.getLocation() + "." + items.toString() + "Time: " + dateTime.toString());
	}

	public boolean equals(ShoppingEvent shoppingEvent){
		return	this.shop.equals(shoppingEvent.getShop())
				&& this.items.equals(shoppingEvent.getItems())
				&& this.dateTime.equals(shoppingEvent.getDateTime());
	}

	@Override
	public void stringParse(ParserVisitor converter, String recordStr) {
		converter.visitElement(this, recordStr);
	}
}