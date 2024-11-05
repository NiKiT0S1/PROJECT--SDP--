/**
 * Observer class that sends email notifications when an order is placed.
 */
public class EmailNotification implements OrderObserver {
    /**
     * Notifies the user by sending an email when the order is placed.
     * @param order The order that was placed.
     */
    @Override
    public void notify(Order order) {
//        System.out.println("Email notification sent for order: " + order);
        System.out.println("Email notification sent to: " + order.getUser().getEmail() +
                " for order: " + order + "\nOrder Amount: $" + order.getTotal());
    }
}
