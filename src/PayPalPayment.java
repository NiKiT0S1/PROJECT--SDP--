/**
 * Implements a payment strategy using PayPal.
 */
public class PayPalPayment implements PaymentStrategy {
    /**
     * Processes the payment.
     * @param amount The amount to be paid.
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paid with PayPal: " + amount);
    }
}
