package Week1.AlgorithmsDataStructure;

import java.util.HashMap;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName +
                ", Quantity: " + quantity + ", Price: ₹" + price;
    }
}

public class InventoryManagementSystem {
    private HashMap<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
        System.out.println(" Added: " + product.productName);
    }

    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
            System.out.println(" Updated: " + productId);
        } else {
            System.out.println(" Product not found!");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.remove(productId) != null) {
            System.out.println(" Deleted: " + productId);
        } else {
            System.out.println(" Product not found!");
        }
    }

    public void displayInventory() {
        System.out.println("\n Inventory:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product p1 = new Product("P001", "Notebook", 100, 45.0);
        Product p2 = new Product("P002", "Pen", 200, 10.0);

        ims.addProduct(p1);
        ims.addProduct(p2);

        ims.displayInventory();

        Product updatedP1 = new Product("P001", "Notebook (Hardcover)", 80, 55.0);
        ims.updateProduct("P001", updatedP1);

        ims.deleteProduct("P002");

        System.out.println("\n After Updates:");
        ims.displayInventory();
    }
}
