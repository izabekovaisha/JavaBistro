package com.pluralsight.menu.classes;

import com.pluralsight.menu.abstractclasses.MenuItem;

public class Chips extends MenuItem {
    public Chips() {
        super("Chips", 1.50);
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return "Chips:\n" + "small - $" + calculatePrice();
    }
}
