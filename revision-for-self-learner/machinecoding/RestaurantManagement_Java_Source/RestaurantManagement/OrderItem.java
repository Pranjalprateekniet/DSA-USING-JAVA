public class OrderItem {
    private final int menuItemId;
    private final String itemName;
    private final double unitPrice;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        if (menuItem == null) {
            throw new IllegalArgumentException("Menu item cannot be null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        // Snapshot the name and price so later menu edits/removal do not
        // change an order that has already been placed.
        this.menuItemId = menuItem.getId();
        this.itemName = menuItem.getName();
        this.unitPrice = menuItem.getPrice();
        this.quantity = quantity;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        quantity += amount;
    }

    public double getSubtotal() {
        return unitPrice * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-20s | ID: %d | Rs. %.2f x %d = Rs. %.2f",
                itemName, menuItemId, unitPrice, quantity, getSubtotal());
    }
}
