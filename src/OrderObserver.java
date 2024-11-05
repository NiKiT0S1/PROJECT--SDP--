/**
 * Interface for observing order events, such as notifications.
 */
public interface OrderObserver {
    void notify(Order order);
}
