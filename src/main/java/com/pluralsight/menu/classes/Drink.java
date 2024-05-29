package com.pluralsight.menu.classes;

import com.pluralsight.menu.abstractclasses.MenuItem;

public class Drink extends MenuItem {
    private String flavor;
    private String size;

    public Drink(String name, String flavor) {
        super("Drink", 0);
        this.flavor = flavor;
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
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
        return size + " " + " - $" + calculatePrice();
    }
}
