/**
 * Facade class that provides a simplified interface to interact with the
 * product database and order service for the online shop.
 * It acts as a mediator between the user and the underlying system
 * functionalities related to products and orders.
 */
public class ShopFacade {
    private ProductDatabase productDatabase = ProductDatabase.getInstance();
    private OrderService orderService = new OrderService();

    /**
     * Adds a product to the user's order by creating a new order if one does not exist.
     * It retrieves the product from the product database based on the provided product ID.
     * If the product is found, it adds it to the newly created order for the specified user.
     *
     * @param user The user who is placing the order.
     * @param productId The ID of the product to be added to the order.
     */
    public void addProductToOrder(User user, int productId) {
        Product product = productDatabase.getProducts().stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .orElse(null);
        if (product != null) {
            orderService.createOrder(user).addProduct(product);
            System.out.println("Product added to order: " + product.getName());
        }
    }
}
