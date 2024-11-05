import java.util.ArrayList;
import java.util.List;

/**
 * Manages order creation and notifications for observers.
 */
public class OrderService {
    private List<OrderObserver> observers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private int orderCount = 1;

    /**
     * Creates a new order for a user.
     * @param user The user placing the order.
     * @return The newly created order.
     */
    public Order createOrder(User user) {
        Order order = new Order(orderCount++, user);
        orders.add(order);
        //notifyObservers(order);
        return order;
    }

    /**
     * Adds an observer to be notified of order events.
     * @param observer The observer to add.
     */
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    /**
     * Notifies all observers of a new order.
     * @param order The order that was placed.
     */
    public void notifyObservers(Order order) {
        for (OrderObserver observer : observers) {
            observer.notify(order);
        }
    }
}
