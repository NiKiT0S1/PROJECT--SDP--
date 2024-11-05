/**
 * Represents a product in the shop with an ID, name, and price.
 */
public class Product {
    private int id;
    private String name;
    private double price;

    /**
     * Constructor for creating a Product.
     * @param id The unique identifier of the product.
     * @param name The name of the product.
     * @param price The price of the product.
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
