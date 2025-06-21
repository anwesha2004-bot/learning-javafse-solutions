package Week1.DesignPatterns;

import java.util.*;

public class SingletonPatternExample {

    static class Product {
        String productId, productName;
        int quantity;
        double price;

        Product(String id, String name, int qty, double price) {
            this.productId = id;
            this.productName = name;
            this.quantity = qty;
            this.price = price;
        }

        void display() {
            System.out.println("ID: " + productId + ", Name: " + productName +
                    ", Quantity: " + quantity + ", Price: Rs" + price);
        }
    }

    static class InventorySystem {
        Map<String, Product> inventory = new HashMap<>();

        void addProduct(Product p) {
            inventory.put(p.productId, p);
            System.out.println(" Added: " + p.productName);
        }

        void updateProduct(String id, Product updatedProduct) {
            if (inventory.containsKey(id)) {
                inventory.put(id, updatedProduct);
                System.out.println(" Updated: " + id);
            } else {
                System.out.println(" Product not found.");
            }
        }

        void deleteProduct(String id) {
            if (inventory.remove(id) != null)
                System.out.println(" Deleted: " + id);
            else
                System.out.println(" Product not found.");
        }

        void displayAllProducts() {
            System.out.println("Inventory:");
            for (Product p : inventory.values()) {
                p.display();
            }
        }
    }

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();

        Product p1 = new Product("P001", "Notebook", 100, 45.0);
        Product p2 = new Product("P002", "Pen", 200, 10.0);

        system.addProduct(p1);
        system.addProduct(p2);

        system.displayAllProducts();

        Product newP1 = new Product("P001", "Notebook (Hardcover)", 80, 55.0);
        system.updateProduct("P001", newP1);

        system.deleteProduct("P002");

        System.out.println("\n📊 After Updates:");
        system.displayAllProducts();
    }
}
