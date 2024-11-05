/**
 * Manages payment methods and allows selection and execution of payment strategies.
 */
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    /**
     * Sets the payment strategy for this context.
     * @param paymentStrategy The payment strategy to use.
     */
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Executes the payment using the selected strategy.
     * @param amount The amount to be paid.
     */
    public void pay(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        }
        else {
            System.out.println("No payment strategy available");
        }
    }
}
