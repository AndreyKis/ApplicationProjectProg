/**
 * Created by User on 27.06.2016.
 */
public final class Walmart extends Shop {
    private static Walmart instance = null;

    private Walmart() {}

    public static synchronized Walmart getInstance() {
        if (instance == null)
            instance = new Walmart();
        return instance;
    }
}
