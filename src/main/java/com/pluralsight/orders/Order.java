package com.pluralsight.orders;

import com.pluralsight.menu.Chips;
import com.pluralsight.menu.Drink;
import com.pluralsight.menu.Sandwich;

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

    public void addSandwich(Sandwich sandwiches) {

    }

    public void addDrink(Drink drinks) {

    }

    public void addChips(Chips chips) {

    }

    public double calculateDoubleCost() {
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

    }

    public void displayOrderDetails() {

    }

    public void saveReceipt() {

    }

    public void placeOrder() {

    }

}
