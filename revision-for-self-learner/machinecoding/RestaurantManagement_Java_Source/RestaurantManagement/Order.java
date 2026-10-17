import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final int id;
    private final List<OrderItem> items;
    private OrderStatus status;

    public Order(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Order ID must be positive.");
        }
        this.id = id;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
    }
    public int getId() {
        return id;
    }
    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(MenuItem menuItem, int quantity) {
        ensurePending();

        if (menuItem == null) {
            throw new IllegalArgumentException("Menu item was not found.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        for (OrderItem orderItem : items) {
            if (orderItem.getMenuItemId() == menuItem.getId()) {
                orderItem.increaseQuantity(quantity);
                return;
            }
        }

        items.add(new OrderItem(menuItem, quantity));
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void complete() {
        ensurePending();
        if (items.isEmpty()) {
            throw new IllegalStateException("An empty order cannot be completed.");
        }
        status = OrderStatus.COMPLETED;
    }

    public void cancel() {
        ensurePending();
        status = OrderStatus.CANCELLED;
    }

    private void ensurePending() {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException(
                    "Only pending orders can be modified. Current status: " + status);
        }
    }
}
