/**
 * Implements a payment strategy using a credit card.
 */
public class CreditCardPayment implements PaymentStrategy {
    /**
     * Processes the payment.
     * @param amount The amount to be paid.
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paid with credit card: " + amount);
    }
}
