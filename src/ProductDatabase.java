import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class that stores all available products in the shop.
 * Provides methods for adding and retrieving products.
 */
public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products = new ArrayList<>();

    /**
     * Private constructor for singleton pattern. Initializes an empty product list.
     */
    private ProductDatabase() {
        products = new ArrayList<>();
    }

    /**
     * Returns the singleton instance of ProductDatabase.
     * @return The single instance of ProductDatabase.
     */
    public static ProductDatabase getInstance() {
        if(instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    /**
     * Adds a product to the database.
     * @param product The product to add.
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Returns a list of all products in the database.
     * @return List of all products.
     */
    public List<Product> getProducts() {
        return products;
    }
}
