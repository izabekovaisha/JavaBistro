package com.pluralsight.orders;

import com.pluralsight.menu.Chips;
import com.pluralsight.menu.Drink;
import com.pluralsight.menu.Sandwich;
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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public void setChips(List<Chips> chips) {
        this.chips = chips;
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

    public void displayCustomerInfo() {
        System.out.println("Customer information: ");
        System.out.println("Name: " + customer.getFullName());
    }

    public void displayOrderDetails() {
        System.out.println("Order details: ");
        System.out.println("Sandwiches:");
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }
        System.out.println("Drinks:");
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
        System.out.println("Chips:");
        for (Chips chip : chips) {
            System.out.println(chip);
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

}
