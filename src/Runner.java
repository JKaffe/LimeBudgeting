import java.io.IOException;
import java.util.ArrayList;

import com.ShoppingEvent;
import com.database.Database;
import com.database.JsonFileDatabase;
import com.pojo.*;

public final class Runner {
    public static void main(String[] args){
        final String dbFile = "com/jsonDB.txt";

        try {
            Database db = new JsonFileDatabase(dbFile);
            db.getShoppingEvents().forEach(System.out::println);
        } catch (IOException e0) {
            e0.printStackTrace();
        }

        System.out.println(Item.getItem());
        Item juice = new Item("Juice Box", 1.25, Category.FOOD);
        System.out.println(Shop.values());
        System.out.println(juice);

        ArrayList<Item> items = new ArrayList<>();
        items.add(juice);

        ShoppingEvent event1 = new ShoppingEvent(Shop.ASDA, items);
    }
}