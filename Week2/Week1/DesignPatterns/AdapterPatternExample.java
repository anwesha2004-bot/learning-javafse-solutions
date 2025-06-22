package Week1.DesignPatterns;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPal {
    public void sendMoney(double amount) {
        System.out.println("PayPal: Sending $" + amount);
    }
}

class Stripe {
    public void makePayment(double amount) {
        System.out.println("Stripe: Processing payment of $" + amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    public void processPayment(double amount) {
        payPal.sendMoney(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {

        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        payPalProcessor.processPayment(500.0);

        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment(1000.0);
    }
}
