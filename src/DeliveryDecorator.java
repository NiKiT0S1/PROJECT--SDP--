/**
 * Decorator class for adding delivery charges to an order.
 * Extends the OrderDecorator class to enhance the functionality of an Order.
 */
public class DeliveryDecorator extends OrderDecorator {
    private double deliveryPrice;

    /**
     * Constructor that takes an order and the delivery price.
     * @param order The original order to be decorated.
     * @param deliveryPrice The additional cost for delivery.
     */
    public DeliveryDecorator(Order order, double deliveryPrice) {
        super(order);
        this.deliveryPrice = deliveryPrice;
    }

    /**
     * Calculates the total cost of the order, including the delivery price.
     * @return The total cost of the order with delivery charges included.
     */
    @Override
    public double getTotal() {
        return order.getTotal() + deliveryPrice;
    }
}
