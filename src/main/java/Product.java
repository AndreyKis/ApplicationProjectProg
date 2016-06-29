/**
 * Created by User on 28.06.2016.
 */
public class Product {
    private String Title;
    private int Price;
    private String Status;
    private int Discount;

    public Product(){}

    public Product(String title, int price, int discount, String status) {
        Title = title;
        Price = price;
        Status = status;
        if(discount <= 0 || discount >= 100){
            throw new IllegalArgumentException("Discount must be between 0 and 100, exclusive");
        }else{
            Discount = discount;
        }
    }

    public String getTitle() {
        return Title;
    }

    public int getPrice() {
        return Price;
    }

    public String getStatus() {
        return Status;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }
}
