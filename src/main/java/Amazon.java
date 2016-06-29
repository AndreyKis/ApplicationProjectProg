import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.bson.BSONObject;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

/**
 * Created by User on 27.06.2016.
 */
public final class Amazon extends Shop {
    private static Amazon instance = null;

    private Amazon() {
    }

    private Amazon(String name, List<Category> categories, List<String> APIs) {
        Name = name;
        Categories = categories;
        this.APIs = APIs;
    }

    public static synchronized Amazon getInstance(String name, List<Category> categories, List<String> APIs) {
        if (instance == null)
            instance = new Amazon(name, categories, APIs);
        return instance;
    }

    /*@Override
    public void AddProductToCat(DBCollection collection, Product productToAdd, String catName){

    }*/
}
