import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by User on 28.06.2016.
 */
public class DataBaseConnection {
    MongoClient Mongo;
    DB Db;
    public DataBaseConnection(String host, int port, String dbName) { //"localhost", 27017, ShopsDB
        try {
            Mongo = new MongoClient(host, port);
            Db = Mongo.getDB(dbName);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void getShopsNames(){

    }
}
