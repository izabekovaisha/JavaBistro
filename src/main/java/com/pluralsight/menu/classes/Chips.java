package com.pluralsight.menu.classes;

import com.pluralsight.menu.abstractclasses.MenuItem;

public class Chips extends MenuItem {
        private String type;

    public Chips(String type, double price) {
        super(type, price);
        this.type = type;
    }

    public String getType() {
        return type;
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

