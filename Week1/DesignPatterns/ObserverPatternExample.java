package Week1.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String stockName, double price);
}

// Subject Interface
interface Stock {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void setStock(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }
}

// Concrete Observer: Mobile App
class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double price) {
        System.out.println("📱 MobileApp (" + user + "): " + stockName + " updated to $" + price);
    }
}

// Concrete Observer: Web App
class WebApp implements Observer {
    private String user;

    public WebApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double price) {
        System.out.println("💻 WebApp (" + user + "): " + stockName + " updated to $" + price);
    }
}

// Test class
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        // Observers
        Observer mobileUser = new MobileApp("Anwesha");
        Observer webUser = new WebApp("Kajal");

        market.registerObserver(mobileUser);
        market.registerObserver(webUser);

        // Update stock
        market.setStock("UEM-Tech", 210.50);
        market.setStock("CodeCorp", 351.75);

        // Remove an observer
        market.removeObserver(mobileUser);

        // Update again
        market.setStock("DataMart", 132.40);
    }
}
