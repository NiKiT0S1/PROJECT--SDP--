import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order that holds products and calculates the total price.
 */
public class Order {
    private int id;
    private User user;
    private List<Product> products = new ArrayList<>();
    private double total;

    /**
     * Constructor for creating an Order.
     * @param id The unique identifier of the order.
     * @param user The user associated with the order.
     */
    public Order(int id, User user) {
        this.id = id;
        this.user = user;
    }

    /**
     * Adds a product to the order and updates the total price.
     * @param product The product to add.
     */
    public void addProduct(Product product) {
        products.add(product);
        total += product.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", user=" + user + ", products=" + products + '}';
    }
}
