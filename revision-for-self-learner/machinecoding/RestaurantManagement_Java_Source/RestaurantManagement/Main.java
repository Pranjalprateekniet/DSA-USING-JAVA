import java.util.Collection;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final RestaurantService SERVICE = new RestaurantService();

    public static void main(String[] args) {
        seedMenu();

        boolean running = true;
        while (running) {
            showMenu();
            int choice = readInt("Enter choice: ");

            try {
                switch (choice) {
                    case 1:
                        addMenuItem();
                        break;
                    case 2:
                        viewMenu();
                        break;
                    case 3:
                        searchMenuItem();
                        break;
                    case 4:
                        updatePrice();
                        break;
                    case 5:
                        removeMenuItem();
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
                        running = false;
                        System.out.println("Exiting Restaurant Management System.");
                        break;
                    default:
                        System.out.println("Invalid choice. Select a listed option.");
                }
            } catch (IllegalArgumentException | IllegalStateException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

            System.out.println();
        }

        SCANNER.close();
    }

    private static void showMenu() {
        System.out.println("===== RESTAURANT MANAGEMENT =====");
        System.out.println("1. Add Menu Item");
        System.out.println("2. View Menu");
        System.out.println("3. Search Menu Item");
        System.out.println("4. Update Item Price");
        System.out.println("5. Remove Menu Item");
        System.out.println("6. Create Order");
        System.out.println("7. Add Item to Order");
        System.out.println("8. View Order");
        System.out.println("9. Complete Order");
        System.out.println("10. Cancel Order");
        System.out.println("11. View All Orders");
        System.out.println("0. Exit");
    }

    private static void seedMenu() {
        SERVICE.addMenuItem(new MenuItem(1, "Paneer Tikka", 220, "Starter"));
        SERVICE.addMenuItem(new MenuItem(2, "Veg Biryani", 180, "Main Course"));
        SERVICE.addMenuItem(new MenuItem(3, "Masala Dosa", 120, "Main Course"));
        SERVICE.addMenuItem(new MenuItem(4, "Gulab Jamun", 70, "Dessert"));
    }

    private static void addMenuItem() {
        int id = readInt("Item ID: ");
        String name = readNonEmpty("Item name: ");
        double price = readDouble("Price: ");
        String category = readNonEmpty("Category: ");

        SERVICE.addMenuItem(new MenuItem(id, name, price, category));
        System.out.println("Menu item added.");
    }

    private static void viewMenu() {
        Collection<MenuItem> items = SERVICE.getAllMenuItems();

        if (items.isEmpty()) {
            System.out.println("Menu is empty.");
            return;
        }

        System.out.println("----- MENU -----");
        for (MenuItem item : items) {
            System.out.println(item);
        }
    }

    private static void searchMenuItem() {
        int id = readInt("Enter item ID: ");
        MenuItem item = SERVICE.findMenuItem(id);

        if (item == null) {
            System.out.println("Menu item not found.");
        } else {
            System.out.println(item);
        }
    }

    private static void updatePrice() {
        int id = readInt("Enter item ID: ");
        double price = readDouble("Enter new price: ");
        SERVICE.updateMenuItemPrice(id, price);
        System.out.println("Price updated. Existing orders keep their original price.");
    }

    private static void removeMenuItem() {
        int id = readInt("Enter item ID to remove: ");
        SERVICE.removeMenuItem(id);
        System.out.println("Menu item removed.");
    }

    private static void createOrder() {
        Order order = SERVICE.createOrder();
        System.out.println("Order created. Order ID: " + order.getId());
        System.out.println("Use option 7 to add menu items.");
    }

    private static void addItemToOrder() {
        int orderId = readInt("Order ID: ");
        int itemId = readInt("Menu item ID: ");
        int quantity = readInt("Quantity: ");

        SERVICE.addItemToOrder(orderId, itemId, quantity);
        System.out.println("Item added to order.");
    }

    private static void viewOrder() {
        int id = readInt("Order ID: ");
        Order order = SERVICE.findOrder(id);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        printOrder(order);
    }

    private static void completeOrder() {
        int id = readInt("Order ID to complete: ");
        SERVICE.completeOrder(id);
        System.out.println("Order completed.");
    }

    private static void cancelOrder() {
        int id = readInt("Order ID to cancel: ");
        SERVICE.cancelOrder(id);
        System.out.println("Order cancelled.");
    }

    private static void viewAllOrders() {
        Collection<Order> orders = SERVICE.getAllOrders();

        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (Order order : orders) {
            System.out.printf("Order ID: %d | Status: %s | Total: Rs. %.2f%n",
                    order.getId(), order.getStatus(), order.getTotal());
        }
    }

    private static void printOrder(Order order) {
        System.out.println("----- ORDER " + order.getId() + " -----");

        if (order.getItems().isEmpty()) {
            System.out.println("No items in this order.");
        } else {
            for (OrderItem item : order.getItems()) {
                System.out.println(item);
            }
        }

        System.out.println("Status: " + order.getStatus());
        System.out.printf("Total: Rs. %.2f%n", order.getTotal());
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Enter a valid whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();

            try {
                double value = Double.parseDouble(input);
                if (Double.isFinite(value)) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Re-prompt below.
            }

            System.out.println("Enter a valid number.");
        }
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = SCANNER.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }
}
