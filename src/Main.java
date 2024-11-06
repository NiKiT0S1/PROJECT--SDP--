import java.util.Scanner;

/**
 * Main class that serves as the entry point to the application.
 * It initializes products, creates a user, and manages the main shopping loop.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductFactory productFactory = new ProductFactory();
        ProductDatabase database = ProductDatabase.getInstance();

        // Adding predefined products to the database
        database.addProduct(productFactory.createProduct(1, "Laptop", 2500));
        database.addProduct(productFactory.createProduct(2, "Phone", 1500));
        database.addProduct(productFactory.createProduct(3, "Headphones", 1000));

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your email: ");
        String userEmail = scanner.nextLine();

        // Creating a user and initializing the shop and order services
        User user = new User(1, userName, userEmail);
        ShopFacade shop = new ShopFacade();
        OrderService orderService = new OrderService();

        // Adding email notification as an observer
        orderService.addObserver(new EmailNotification());

        // Create a new order for the user
        Order userOrder = orderService.createOrder(user);
        PaymentContext paymentContext = new PaymentContext();


        // Main loop to interact with the user in the shop
        while (true) {
            System.out.println("\nWelcome to the online store " + user.getName() + "! Select an action:");
            System.out.println("1. View products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Choose a payment method");
            System.out.println("4. Confirm your purchase");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            // Clear newline
            scanner.nextLine();
            switch (choice) {
                case 1:
                    // Display available products
                    System.out.println("Available products:");
                    for (Product product : database.getProducts()) {
                        System.out.println("ID: " + product.getId() + " - " + product.getName() + " - Price: $" + product.getPrice());
                    }
                    break;

                case 2:
                    // Add product to user's order
                    System.out.println("Enter the ID of the product you want to add to your shopping cart:");
                    int productId = scanner.nextInt();
                    Product product = database.getProducts().stream()
                            .filter(p -> p.getId() == productId)
                            .findFirst()
                            .orElse(null);
                    if (product != null) {
                        userOrder.addProduct(product);
                        System.out.println("Product " + product.getName() + " add to shopping cart.");
                    } else {
                        System.out.println("Product with this ID was not found.");
                    }
                    break;

                case 3:
                    // Select payment method
                    System.out.println("Choose a payment method:");
                    System.out.println("1. Credit Card");
                    System.out.println("2. PayPal");

                    int paymentChoice = scanner.nextInt();
                    if (paymentChoice == 1) {
                        paymentContext.setPaymentStrategy(new CreditCardPayment());
                        System.out.println("You have chosen to pay by credit card.");
                    } else if (paymentChoice == 2) {
                        paymentContext.setPaymentStrategy(new PayPalPayment());
                        System.out.println("You have chosen to pay via PayPal.");
                    } else {
                        System.out.println("Неверный выбор.");
                    }
                    break;

                case 4:
                    // Confirm the purchase
                    if (userOrder.getTotal() > 0) {
                        System.out.println("Total order amount: $" + userOrder.getTotal());
                        System.out.print("Confirm your purchase? (yes/no): ");
                        String confirm = scanner.next();
                        if (confirm.equalsIgnoreCase("yes")) {
                            paymentContext.pay(userOrder.getTotal());
                            System.out.println("Purchase confirmed. Thank you for your purchase!");

                            // Notify observers and reset order
                            orderService.notifyObservers(userOrder);
                            System.out.println("The notification was sent to your email address: " + user.getEmail());

                            userOrder = orderService.createOrder(user);  // New user for next purchase
                        } else {
                            System.out.println("Purchase canceled.");
                        }
                    } else {
                        System.out.println("Your shopping cart is empty.");
                    }
                    break;

                case 5:
                    // Exit the shop
                    System.out.println("Exit the store. Goodbye, " + user.getName() + "!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Wrong choice. Please try again.");
                    break;
            }
        }
    }
}