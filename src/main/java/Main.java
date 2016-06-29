import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RunnableFuture;


/**
 * Created by User on 27.06.2016.
 */
public class Main {

    public static void main(String[] args) {
        List<Shop> shops = new ArrayList<>();
        DataBaseConnection connection = new DataBaseConnection("localhost", 27017, "ShopsDB");
        DBCollection shopsCollection = connection.Db.getCollection("ShopsCollection");
        ShopFactory factory = new ShopFactory();
        DBCursor Docs = shopsCollection.find();
        try {
            while(Docs.hasNext()) {
                DBObject currDoc = Docs.next();

                int id = (Integer) currDoc.get("_id");
                String name = (String) currDoc.get("Name") ;
                BasicDBList categories = (BasicDBList) currDoc.get("Categories");
                BasicDBList APIs = (BasicDBList) currDoc.get("APIs");

                ArrayList<BasicDBObject> categoriesArray = (ArrayList) categories;
                ArrayList<BasicDBObject> APIsArray = (ArrayList) APIs;

                shops.add(factory.Create(name, DbArrToCategoryArr(categoriesArray), DbArrToAPIArr(APIsArray)));
            }
        } catch (MongoException x) {
            x.printStackTrace();
        }

        Thread amazonThread = new AmazonThread(shops.get(0));
        amazonThread.start();

        Thread walmartThread = new WalmartThread(shops.get(0));
        walmartThread.start();

        shops.get(0).AddProductToCat(shopsCollection, new Product("Notebook", 30.7, 0, "available"), "Furniture");
        System.out.println("hello");

    }

    private static class AmazonThread extends Thread {
        Shop AmazonShop;
        public AmazonThread(Shop amazonShop) {
            AmazonShop = amazonShop;
        }

        @Override
        public void run(){

        }
    }

    private static class WalmartThread extends Thread {
        Shop WalmartThread;
        public WalmartThread(Shop walmartThread) {
            WalmartThread = walmartThread;
        }

        @Override
        public void run(){

        }
    }

    public static ArrayList<Category> DbArrToCategoryArr(ArrayList<BasicDBObject> categories){
        ArrayList<Category> result = new ArrayList<>();
        for(BasicDBObject currCat: categories)
        {
            String name = (String) currCat.get("Name");
            int discount = (Integer) currCat.get("Discount");
            BasicDBList products = (BasicDBList) currCat.get("Products");

            ArrayList<BasicDBObject> productsArray = (ArrayList) products;

            result.add(new Category(name, discount, DbArrToProductArr(productsArray)));
        }
        return result;
    }

    public static ArrayList<String> DbArrToAPIArr(ArrayList<BasicDBObject> categories){
        ArrayList<String> result = new ArrayList<>();
        for(BasicDBObject currCat: categories)
        {
            String name = (String) currCat.get("Name");

            result.add(name);
        }
        return result;
    }

    public static ArrayList<Product> DbArrToProductArr(ArrayList<BasicDBObject> categories){
        ArrayList<Product> result = new ArrayList<>();
        for(BasicDBObject currCat: categories)
        {
            String title = (String) currCat.get("Title");
            double price = (Double) currCat.get("Price");
            String status = (String) currCat.get("Status");
            int discount = (Integer) currCat.get("Discount");


            result.add(new Product(title, price, discount, status));
        }
        return result;
    }

}
