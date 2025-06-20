package Week1.DesignPatterns;

public class SingletonExample {

    // Step 1: Private static instance of the class
    private static SingletonExample instance = null;

    // Step 2: Private constructor to restrict instantiation
    private SingletonExample() {
        System.out.println("Singleton instance created.");
    }

    // Step 3: Public method to provide access to the instance
    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello from SingletonExample!");
    }

    // Main method to test Singleton behavior
    public static void main(String[] args) {
        SingletonExample obj1 = SingletonExample.getInstance();
        SingletonExample obj2 = SingletonExample.getInstance();

        if (obj1 == obj2) {
            System.out.println("Both objects are the same instance.");
        }

        obj1.showMessage();
    }
}
