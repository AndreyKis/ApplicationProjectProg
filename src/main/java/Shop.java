import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.bson.Document;

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


    public String getName() {
        return Name;
    }

    public List<Category> getCategories() {
        return Categories;
    }

    public List<String> getAPIs() {
        return APIs;
    }

    public void AddProductToCat(DBCollection collection, Product product, String catName) {
        if(this.getCategories().contains(catName)) {
            BasicDBObject selectQuery = new BasicDBObject("Name", this.Name);
            selectQuery.append("Categories.Name", catName);

            BasicDBObject updateQuery = new BasicDBObject();//"$push", selectQuery);
            BasicDBObject dboToAdd = new BasicDBObject();
            dboToAdd.append("Title", product.getTitle());
            dboToAdd.append("Price", product.getPrice());
            dboToAdd.append("Status", product.getStatus());
            dboToAdd.append("Discount", product.getDiscount());

            updateQuery.append("$push", dboToAdd);

            collection.update(selectQuery, updateQuery);
        }
        else
        {
            try{
                //add category here
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
    }
}
