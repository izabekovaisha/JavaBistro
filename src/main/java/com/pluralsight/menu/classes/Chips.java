package com.pluralsight.menu.classes;

import com.pluralsight.menu.abstractclasses.MenuItem;

public class Chips extends MenuItem {
        private String type;

    public Chips(String name, double price) {
        super("Chips", price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return type + " - $" + calculatePrice();
    }
}

