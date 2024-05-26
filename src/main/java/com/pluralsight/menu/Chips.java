package com.pluralsight.menu;

public class Chips extends MenuItem {
    public Chips(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }
}
