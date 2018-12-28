import com.database.BudgetingDatabase;
import com.database.CSVDatabase;
import com.pojo.Category;
import com.pojo.Item;
import com.pojo.Shop;
import com.pojo.ShoppingEvent;

import java.util.ArrayList;

public final class Runner {

    public static void main(String[] args){
        final String dbFile = "db.csv";


        BudgetingDatabase database = new BudgetingDatabase(dbFile, new CSVDatabase());

        Item i0 = new Item("A", 2.5, Category.ENTERTAINMENT);
        Item i1 = new Item("B", 3.0, Category.FOOD);
        ArrayList<Item> items = new ArrayList<>();
        items.add(i0);
        items.add(i1);

        ShoppingEvent e1 = new ShoppingEvent(Shop.ASDA, (ArrayList<Item>) items);

        Item a0 = new Item("C", 1.25, Category.LAUNDARY);
        ArrayList<Item> ite = new ArrayList<>();
        ite.add(a0);

        ShoppingEvent e2 = new ShoppingEvent(Shop.LIDL, (ArrayList<Item>) ite);

        database.append(e1);
        database.append(e2);

        database.commit();
    }
}