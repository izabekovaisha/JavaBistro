package com.pluralsight.orders;

import com.pluralsight.menu.classes.Chips;
import com.pluralsight.menu.classes.Drink;
import com.pluralsight.menu.classes.Sandwich;
import com.pluralsight.services.Receipt;

import java.util.List;

public class Order {
    private Customer customer;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order(Customer customer, List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.customer = customer;
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double calculateCost() {
        double totalCost = 0.0;
        // Loop through each sandwich/drink/chips item and add its price to the total cost
            for (Sandwich sandwich : sandwiches) {
                totalCost += sandwich.calculateCost();
        }
            for (Drink drink : drinks) {
                totalCost += drink.calculatePrice();
        }
            for (Chips chip : chips) {
                totalCost += chip.calculatePrice();
            }
        return totalCost;
    }

    public void displayOrderDetails() {
        System.out.println("Customer information: ");
        System.out.println("Name: " + customer.getFullName());

        System.out.println("Order details: ");

        // Check if there are any sandwiches/drinks/chips in the order
        if (!sandwiches.isEmpty()) {
            System.out.println("Sandwiches: ");
            for (Sandwich sandwich : sandwiches) {
                System.out.println(sandwich);
            }
        }
        if (!drinks.isEmpty()) {
            System.out.println("Drinks: ");
            for (Drink drink : drinks) {
                System.out.println(drink);
            }
        }
        if (!chips.isEmpty()) {
            System.out.println("Chips: ");
            for (Chips chip : chips) {
                System.out.println(chip);
            }
    }
        System.out.println("Total cost: $" + calculateCost());
    }

    public void saveReceipt() {
        Order order = new Order(customer, sandwiches, drinks, chips);
        Receipt receipt = new Receipt();
        receipt.generateReceipt(order);
    }

    public void placeOrder() {
        System.out.println("Your order has been successfully placed!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer information:\n");
        sb.append("Name: ").append(customer.getFullName()).append("\n");
        sb.append("Order details:\n");
        if (!sandwiches.isEmpty()) {
            sb.append("Sandwiches:\n");
            for (Sandwich sandwich : sandwiches) {
                sb.append(sandwich).append("\n");
            }
        }
        if (!drinks.isEmpty()) {
            sb.append("Drinks:\n");
            for (Drink drink : drinks) {
                sb.append(drink).append("\n");
            }
        }
        if (!chips.isEmpty()) {
            sb.append("Chips:\n");
            for (Chips chip : chips) {
                sb.append(chip).append("\n");
            }
        }
        sb.append("Total cost: $").append(calculateCost()).append("\n");
        return sb.toString();
    }
}
