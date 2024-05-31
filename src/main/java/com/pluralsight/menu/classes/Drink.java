package com.pluralsight.menu.classes;

import com.pluralsight.menu.abstractclasses.MenuItem;

public class Drink extends MenuItem {
    private String flavor;
    private String size;

    public Drink(String flavor, String size) {
        super("Drink", 0);
        this.flavor = flavor;
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    @Override
    public double calculatePrice() {
        // Determine price based on drink size
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0; // Return 0 if the size is not recognized
        }
    }

    @Override
    public String toString() {
        return size + " " + flavor + " - $" + calculatePrice();
    }
}
