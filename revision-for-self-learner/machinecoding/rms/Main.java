import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Integer> itemIds = new ArrayList<>();
    static ArrayList<String> itemNames = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Integer> orderIds = new ArrayList<>();
    static ArrayList<String> orderStatuses = new ArrayList<>();
    static ArrayList<Double> orderTotals = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> orderedIds = new ArrayList<>();
    static ArrayList<ArrayList<String>> orderedNames = new ArrayList<>();
    static ArrayList<ArrayList<Double>> orderedPrices = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> orderedQuantities = new ArrayList<>();
    static int nextOrderId = 1;
    static int findItem(int id) {
        for (int i = 0; i < itemIds.size(); i++) {
            if (itemIds.get(i) == id) {
                return i;
            }
        }

        return -1;
    }


    static int findOrder(int id) {
        for (int i = 0; i < orderIds.size(); i++) {
            if (orderIds.get(i) == id) {
                return i;
            }
        }

        return -1;
    }


    static void addItem() {
        int id = readInt("Enter item ID: ");

        if (findItem(id) != -1) {
            System.out.println("ID already exists.");
            return;
        }

        String name = readText("Enter item name: ");
        double price = readDouble("Enter price: ");

        if (id <= 0 || name.isEmpty() || price <= 0) {
            System.out.println("Invalid item details.");
            return;
        }

        itemIds.add(id);
        itemNames.add(name);
        prices.add(price);

        System.out.println("Item added successfully.");
    }


    static void viewMenu() {
        if (itemIds.isEmpty()) {
            System.out.println("Menu is empty.");
            return;
        }

        for (int i = 0; i < itemIds.size(); i++) {
            System.out.println(
                itemIds.get(i) + " | " +
                itemNames.get(i) + " | Rs. " +
                prices.get(i)
            );
        }
    }


    static void searchItem() {
        int id = readInt("Enter item ID: ");
        int index = findItem(id);

        if (index == -1) {
            System.out.println("Item not found.");
        } else {
            System.out.println(
                itemIds.get(index) + " | " +
                itemNames.get(index) + " | Rs. " +
                prices.get(index)
            );
        }
    }


    static void updatePrice() {
        int id = readInt("Enter item ID: ");
        int index = findItem(id);

        if (index == -1) {
            System.out.println("Item not found.");
            return;
        }

        double price = readDouble("Enter new price: ");

        if (price <= 0) {
            System.out.println("Price must be positive.");
            return;
        }

        prices.set(index, price);

        System.out.println("Price updated.");
    }


    static void removeItem() {
        int id = readInt("Enter item ID: ");
        int index = findItem(id);

        if (index == -1) {
            System.out.println("Item not found.");
            return;
        }

        itemIds.remove(index);
        itemNames.remove(index);
        prices.remove(index);

        System.out.println("Item removed.");
    }


    static void createOrder() {
        orderIds.add(nextOrderId);
        orderStatuses.add("PENDING");
        orderTotals.add(0.0);

        orderedIds.add(new ArrayList<>());
        orderedNames.add(new ArrayList<>());
        orderedPrices.add(new ArrayList<>());
        orderedQuantities.add(new ArrayList<>());

        System.out.println("Order created. ID: " + nextOrderId);

        nextOrderId++;
    }


    static void addItemToOrder() {
        int id = readInt("Enter order ID: ");
        int orderIndex = findOrder(id);

        if (orderIndex == -1) {
            System.out.println("Order not found.");
            return;
        }

        if (!orderStatuses.get(orderIndex).equals("PENDING")) {
            System.out.println("Order cannot be modified.");
            return;
        }

        int itemId = readInt("Enter menu item ID: ");
        int itemIndex = findItem(itemId);

        if (itemIndex == -1) {
            System.out.println("Menu item not found.");
            return;
        }

        int quantity = readInt("Enter quantity: ");

        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }

        orderedIds.get(orderIndex).add(itemIds.get(itemIndex));
        orderedNames.get(orderIndex).add(itemNames.get(itemIndex));
        orderedPrices.get(orderIndex).add(prices.get(itemIndex));
        orderedQuantities.get(orderIndex).add(quantity);

        double total = prices.get(itemIndex) * quantity;

        orderTotals.set(
            orderIndex,
            orderTotals.get(orderIndex) + total
        );

        System.out.println("Item added to order.");
    }


    static double calculateBill(int orderIndex) {
        double total = 0;

        for (int i = 0;
             i < orderedPrices.get(orderIndex).size(); i++) {

            total += orderedPrices.get(orderIndex).get(i)
                   * orderedQuantities.get(orderIndex).get(i);
        }

        return total;
    }


    static void viewOrder() {
        int id = readInt("Enter order ID: ");
        int index = findOrder(id);

        if (index == -1) {
            System.out.println("Order not found.");
            return;
        }

        System.out.println("Order ID: " + orderIds.get(index));
        System.out.println("Status: " + orderStatuses.get(index));

        for (int i = 0; i < orderedIds.get(index).size(); i++) {
            System.out.println(
                orderedNames.get(index).get(i) +
                " | ID: " + orderedIds.get(index).get(i) +
                " | Price: Rs. " + orderedPrices.get(index).get(i) +
                " | Quantity: " + orderedQuantities.get(index).get(i)
            );
        }

        System.out.println(
            "Total Bill: Rs. " + calculateBill(index)
        );
    }


    static void completeOrder() {
        int id = readInt("Enter order ID: ");
        int index = findOrder(id);

        if (index == -1) {
            System.out.println("Order not found.");
        } else if (!orderStatuses.get(index).equals("PENDING")) {
            System.out.println("Order is already processed.");
        } else if (orderedIds.get(index).isEmpty()) {
            System.out.println("Cannot complete an empty order.");
        } else {
            orderStatuses.set(index, "COMPLETED");
            System.out.println("Order completed.");
        }
    }


    static void cancelOrder() {
        int id = readInt("Enter order ID: ");
        int index = findOrder(id);

        if (index == -1) {
            System.out.println("Order not found.");
        } else if (!orderStatuses.get(index).equals("PENDING")) {
            System.out.println("Order is already processed.");
        } else {
            orderStatuses.set(index, "CANCELLED");
            System.out.println("Order cancelled.");
        }
    }


    static void viewAllOrders() {
        if (orderIds.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (int i = 0; i < orderIds.size(); i++) {
            System.out.println(
                "Order ID: " + orderIds.get(i) +
                " | Status: " + orderStatuses.get(i) +
                " | Total: Rs. " + calculateBill(i)
            );
        }
    }


    static int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid integer.");
            }
        }
    }


    static double readDouble(String message) {
        while (true) {
            System.out.print(message);

            try {
                double value = Double.parseDouble(sc.nextLine().trim());

                if (Double.isFinite(value)) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Ask for input again.
            }

            System.out.println("Enter a valid number.");
        }
    }


    static String readText(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }


    static void showMenu() {
        System.out.println("\n===== RESTAURANT MANAGEMENT =====");
        System.out.println("1. Add Menu Item");
        System.out.println("2. View Menu");
        System.out.println("3. Search Menu Item");
        System.out.println("4. Update Price");
        System.out.println("5. Remove Menu Item");
        System.out.println("6. Create Order");
        System.out.println("7. Add Item to Order");
        System.out.println("8. View Order");
        System.out.println("9. Complete Order");
        System.out.println("10. Cancel Order");
        System.out.println("11. View All Orders");
        System.out.println("0. Exit");
    }


    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    addItem();
                    break;

                case 2:
                    viewMenu();
                    break;

                case 3:
                    searchItem();
                    break;

                case 4:
                    updatePrice();
                    break;

                case 5:
                    removeItem();
                    break;

                case 6:
                    createOrder();
                    break;

                case 7:
                    addItemToOrder();
                    break;

                case 8:
                    viewOrder();
                    break;

                case 9:
                    completeOrder();
                    break;

                case 10:
                    cancelOrder();
                    break;

                case 11:
                    viewAllOrders();
                    break;

                case 0:
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}