package Week1.DesignPatterns;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println(" Email sent: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println(" SMS sent: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println(" Slack message sent: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {

        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("System update at 10 PM");

        System.out.println("\n--- Email + SMS ---");

        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send("Meeting at 3 PM");

        System.out.println("\n--- Email + SMS + Slack ---");

        Notifier allNotifier = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier()));
        allNotifier.send("Production server is down!");
    }
}
