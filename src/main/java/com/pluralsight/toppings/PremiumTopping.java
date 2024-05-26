package com.pluralsight.toppings;

public class PremiumTopping implements Topping {
    private String name;
    private double price;

    public PremiumTopping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getCost(int sandwichSize) {
        return 0;
    }
}
