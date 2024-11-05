/**
 * Factory class for creating products with specific attributes.
 */
public class ProductFactory {
    /**
     * Creates a product with the given ID, name, and price.
     * @param id The unique identifier for the product.
     * @param name The name of the product.
     * @param price The price of the product.
     * @return A new Product instance with specified properties.
     */
    public Product createProduct(int id, String name, double price) {
        return new Product(id, name, price);
    }
}
