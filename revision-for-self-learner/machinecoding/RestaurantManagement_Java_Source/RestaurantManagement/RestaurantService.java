import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class RestaurantService {
    private final Map<Integer, MenuItem> menu;
    private final Map<Integer, Order> orders;
    private int nextOrderId;

    public RestaurantService() {
        menu = new LinkedHashMap<>();
        orders = new LinkedHashMap<>();
        nextOrderId = 1;
    }

    public void addMenuItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Menu item cannot be null.");
        }
        if (menu.containsKey(item.getId())) {
            throw new IllegalArgumentException("A menu item with this ID already exists.");
        }
        menu.put(item.getId(), item);
    }

    public Collection<MenuItem> getAllMenuItems() {
        return new ArrayList<>(menu.values());
    }

    public MenuItem findMenuItem(int id) {
        return menu.get(id);
    }

    public void updateMenuItemPrice(int id, double newPrice) {
        MenuItem item = menu.get(id);
        if (item == null) {
            throw new IllegalArgumentException("Menu item not found.");
        }
        item.setPrice(newPrice);
    }

    public void removeMenuItem(int id) {
        if (menu.remove(id) == null) {
            throw new IllegalArgumentException("Menu item not found.");
        }
        // Existing orders retain their own item-name and price snapshots.
    }

    public Order createOrder() {
        Order order = new Order(nextOrderId++);
        orders.put(order.getId(), order);
        return order;
    }

    public Order findOrder(int id) {
        return orders.get(id);
    }

    public void addItemToOrder(int orderId, int menuItemId, int quantity) {
        Order order = requireOrder(orderId);
        MenuItem item = menu.get(menuItemId);

        if (item == null) {
            throw new IllegalArgumentException("Menu item not found.");
        }

        order.addItem(item, quantity);
    }

    public void completeOrder(int orderId) {
        requireOrder(orderId).complete();
    }

    public void cancelOrder(int orderId) {
        requireOrder(orderId).cancel();
    }

    public Collection<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    private Order requireOrder(int id) {
        Order order = orders.get(id);
        if (order == null) {
            throw new IllegalArgumentException("Order not found.");
        }
        return order;
    }
}
