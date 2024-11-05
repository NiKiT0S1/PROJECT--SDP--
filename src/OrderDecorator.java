/**
 * Abstract decorator class for Order, allowing additional features like delivery.
 */
public abstract class OrderDecorator extends Order {
    protected Order order;

    /**
     * Constructor for creating an OrderDecorator.
     * @param order The order to be decorated.
     */
    public OrderDecorator(Order order) {
        super(order.getId(), order.getUser());
        this.order = order;
    }

    @Override
    public double getTotal() {
        return order.getTotal();
    }
}
