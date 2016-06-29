import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import java.util.List;

/**
 * Created by User on 27.06.2016.
 */
public final class Walmart extends Shop {
    private static Walmart instance = null;

    private Walmart() {}

    private Walmart(String name, List<Category> categories, List<String> APIs) {
        Name = name;
        Categories = categories;
        this.APIs = APIs;
    }

    public static synchronized Walmart getInstance(String name, List<Category> categories, List<String> APIs) {
        if (instance == null)
            instance = new Walmart(name, categories, APIs);
        return instance;
    }
}
