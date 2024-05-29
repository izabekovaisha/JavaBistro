package com.pluralsight.menu.classes;

import com.pluralsight.menu.abstractclasses.MenuItem;

public class Drink extends MenuItem {
    private String size;

    public Drink(String name, double price, String size) {
        super("Drink", 0);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double calculatePrice() {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Drink:\n " + size + " - $" + calculatePrice();
    }
}
