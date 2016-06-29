import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 28.06.2016.
 */
public class Category {
    private String Name;
    private double Discounts;
    private List<Product> Products;

    public Category() {
    }

    public Category(String name, double discounts, ArrayList<Product> products) {
        Name = name;
        Discounts = discounts;
        Products = products;
    }

    public String getName() {
        return Name;
    }

    public double getDiscounts() {
        return Discounts;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDiscounts(int discounts) {
        Discounts = discounts;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }
}
