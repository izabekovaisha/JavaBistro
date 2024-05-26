package com.pluralsight.menu;

public class Chips extends MenuItem {
    public Chips() {
        super("Chips", 1.50);
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }
}
