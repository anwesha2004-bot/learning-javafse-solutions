package Week1.AlgorithmsDataStructure;

import java.util.Arrays;

class Product implements Comparable<Product> {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ProductSearch {

    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("P001", "Laptop", "Electronics"),
                new Product("P002", "Mouse", "Accessories"),
                new Product("P003", "Keyboard", "Accessories"),
                new Product("P004", "Monitor", "Electronics"),
                new Product("P005", "Printer", "Office")
        };

        String target = "Mouse";
        Product result1 = linearSearch(products, target);
        System.out.println(" Linear Search Result: " + (result1 != null ? result1 : "Not Found"));

        Arrays.sort(products);

        Product result2 = binarySearch(products, target);
        System.out.println(" Binary Search Result: " + (result2 != null ? result2 : "Not Found"));
    }
}
