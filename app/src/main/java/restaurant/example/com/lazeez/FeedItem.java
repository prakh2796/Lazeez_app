package restaurant.example.com.lazeez;

/**
 * Created by Pewds on 20-Nov-15.
 */
public class FeedItem {
    private String dish;
    private int price,type,quantity;

    public FeedItem() {
    }


    public FeedItem(String dish,Integer price,Integer quantity) {
        super();
        this.dish = dish;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDish() { return dish; }

    public void setDish(String dish) { this.dish = dish; }

    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price; }

    public int getType() { return type ;}

    public void setType(int type) { this.type = type; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity;}

}