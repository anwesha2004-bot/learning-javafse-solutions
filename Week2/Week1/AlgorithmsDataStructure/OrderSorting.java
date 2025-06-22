package Week1.AlgorithmsDataStructure;

class Order {
    String orderId;
    String customerName;
    double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total: Rs" + totalPrice;
    }
}

public class OrderSorting {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void displayOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Order[] orders1 = {
                new Order("O001", "Anwesha", 1999.99),
                new Order("O002", "Ritika", 549.50),
                new Order("O003", "Kajal", 3200.75),
                new Order("O004", "Debonita", 1499.25)
        };

        Order[] orders2 = orders1.clone(); // For quick sort separately

        System.out.println(" Bubble Sort:");
        bubbleSort(orders1);
        displayOrders(orders1);

        System.out.println(" Quick Sort:");
        quickSort(orders2, 0, orders2.length - 1);
        displayOrders(orders2);
    }
}
