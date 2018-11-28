
package com.pojo;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * <h1>Item Class</h1>
 * <p>The class represents an item that can be bought in a shop or supermarket.</p>
 *
 * @author Karmjit
 * @version 1.0
 * @since 12-11-2018
 */
public class Item {

    private final String name;
    private final double price;
    private final Category category;

    /**
     * Use to get an Item object from different sources such as standard in or a database.
     *
     * @return Item created with user input from standard input.
     */
    public static Item getItem(){
        Scanner scanner = new Scanner(System.in);

        /*-------------------------------------------------------------------*/

        System.out.print("Name of the item: ");
        final String name = scanner.nextLine();

        double price;
        do{
            System.out.print("Price Cannot be negative. Price of the item: ");

            while (!scanner.hasNextDouble()) {
                // Makes the thread wait until the next double is found
                scanner.next();
                System.out.print("Erroneous Input. Price: ");
            }

            price = scanner.nextDouble();
        } while (price <= 0.0);

        /*-------------------------------------------------------------------*/

        final Category[] categories = Category.values();

        // Will be used to get a Category pojo from the array by referring to index value.
        // Will contain value between 0 and categories last index.
        int categoryIndex;
        do{
            // Prints all categories
            IntStream.range(0, categories.length)
                    .forEachOrdered( index -> System.out.println( index +": " + categories[index]));

            System.out.print("Choose a category: ");

            while(!scanner.hasNextInt()){
                scanner.next();
                System.out.print("Erroneous Input. Price: ");
            }

            categoryIndex = scanner.nextInt();
        } while(categoryIndex < 0 || categoryIndex > categories.length);
        final Category categoryChoosen = categories[categoryIndex];

        /*-------------------------------------------------------------------*/

        return new Item(name, price, categoryChoosen);
    }

    /**
     * @param name Name of the item
     * @param price The cost of the item
     */
    public Item(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }



    /**
     * @param item item to compare with.
     * @return Boolean value. True if the names and the prices of the object match.
     */
    // Returns true if the names(case ignored) and prices are the same.
    public boolean equals(Item item){
        return (this.name.equalsIgnoreCase(item.getName()) && (this.price == item.getPrice()));
    }

    @Override
    public String toString() {
        return "The " + name + " costed £" + price + " from.";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

}
