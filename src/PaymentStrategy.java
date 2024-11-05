/**
 * Interface for payment strategies, allowing different payment methods to be implemented.
 * Classes implementing this interface must provide a way to process a payment of a specified amount.
 */
public interface PaymentStrategy {
    /**
     * Processes a payment of the specified amount.
     * @param amount The amount to be paid.
     */
    void pay(double amount);
}
