import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 26.06.2016.
 */
//Class to represent Shops in common
public abstract class Shop {
    protected String Name;
    //Categories, taken from DB
    protected List<Category> Categories;
    //Here we get APIs from DB in java\js wrapper for each shop
    protected List<String> APIs;
    //Shop document from DB. Did not invent a way to separate DB from program instances because of Singleton pattern for these instances

    public abstract void AddProductToCat(DBCollection collection, Product product, String catName);
}
