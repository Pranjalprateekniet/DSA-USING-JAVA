# Restaurant Management System (Console Java)

A console-only Java machine-coding practice project. It uses no external frameworks, database, or frontend.

## Files

- `Main.java` — console menu and input handling
- `MenuItem.java` — menu item model
- `OrderItem.java` — item and quantity stored in an order
- `Order.java` — order contents, status, and bill calculation
- `OrderStatus.java` — `PENDING`, `COMPLETED`, `CANCELLED`
- `RestaurantService.java` — menu and order operations

## Requirements

JDK 8 or later.

## Compile

Open a terminal in this folder and run:

```bash
javac *.java
```

## Run

```bash
java Main
```

The application starts with four sample menu items. Data is stored in memory and resets when the program exits.

## Design decision: order price snapshot

When an item is added to an order, the order stores its name and unit price at that time. A later menu price change or menu-item removal does not change the bill for an existing order.

## Suggested manual test

1. Choose `2` to view the menu.
2. Choose `6` to create an order and note its ID.
3. Choose `7`, enter that order ID, menu item ID `1`, and quantity `2`.
4. Choose `8` and enter the order ID. Verify the total is Rs. 440.00.
5. Change menu item `1`'s price using option `4`.
6. View the existing order again. Its price should remain unchanged.
7. Complete the order with option `9`.
8. Try adding another item to that order. The operation should be rejected.
9. Try duplicate menu IDs, invalid quantities, and nonexistent IDs.
