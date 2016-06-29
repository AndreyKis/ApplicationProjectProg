import com.mongodb.DBObject;

import java.util.List;

/**
 * Created by User on 27.06.2016.
 */
public class ShopFactory {
    private abstract class AbstractCreator {
        public abstract Shop create(String name, List<Category> categories, List<String> APIs);
    }

    private class AmazonCreator extends AbstractCreator {
        @Override
        public Shop create(String name, List<Category> categories, List<String> APIs) {
            return Amazon.getInstance(name, categories, APIs);
        }
    }

    private class WalmartCreator extends AbstractCreator {
        @Override
        public Shop create(String name, List<Category> categories, List<String> APIs) {
            return Walmart.getInstance(name, categories, APIs);
        }
    }

    public Shop Create(String name, List<Category> categories, List<String> APIs) {
        AbstractCreator writer = null;
        if ("Amazon".equals(name)) {
            writer = new AmazonCreator();
        } else if ("Walmart".equals(name)) {
            writer = new WalmartCreator();
        }
        return writer.create(name, categories, APIs);
    }
}


