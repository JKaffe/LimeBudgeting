package com.pojo;

import com.converters.ParserVisitor;

import java.io.Serializable;

/**
 * <h1>Item Class</h1>
 * <p>The class represents an item that can be bought in a shop or supermarket.</p>
 *
 * @author Karmjit
 * @version 1.0
 * @since 12-11-2018
 */
public class Item implements BudgettingVisitableElement<Item>, Serializable {

	private String name;
	private double price;
	private Category category;

    public Item(){
	}

    public Item(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

	@Override
	public Item stringParse(ParserVisitor converter, String recordStr) {
		return (Item) converter.visitElement(this, recordStr);
	}

	/**
	 * @param item item to compare with.
	 * @return Boolean value. True if the names and the prices of the object match.
	 */
	// Returns true if the names(case ignored) and prices are the same.
	public boolean equals(Item item){
		return this.price == item.getPrice()
				&& this.name.equals(item.getName())
				&& this.category.equals(item.getCategory());
	}

	@Override
	public String toString() {
		return name + "," + price + "," + category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
