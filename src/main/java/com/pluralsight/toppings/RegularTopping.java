package com.pluralsight.toppings;

public class RegularTopping implements Topping {
    private String name;

    public RegularTopping(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost(int sandwichSize) {
        return 0;
    }
}
