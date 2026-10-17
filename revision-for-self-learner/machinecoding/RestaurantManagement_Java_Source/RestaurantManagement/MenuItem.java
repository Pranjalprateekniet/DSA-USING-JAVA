public class MenuItem {
    private final int id;
    private final String name;
    private double price;
    private final String category;

    public MenuItem(int id, String name, double price, String category) {
        if (id <= 0) {
            throw new IllegalArgumentException("Menu item ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty.");
        }

        this.id = id;
        this.name = name.trim();
        this.price = price;
        this.category = category.trim();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %-20s | %-12s | Rs. %.2f",
                id, name, category, price);
    }
}
