package com.pluralsight.toppings;

import java.util.List;
import java.util.Arrays;

public class RegularTopping implements Topping {
    private String name;
    private List<String> REGULAR_TOPPINGS = Arrays.asList("lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms");
    private List<String> SAUCES = Arrays.asList("mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette");
    List<String> SIDES = Arrays.asList("au jus", "sauce");

    public RegularTopping(String name) {
        this.name = name;
        if (!isValidTopping(name)) {
            throw new IllegalArgumentException("Invalid regular topping: " + name);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost(int sandwichSize) {
        return 0.0;
    }

    private boolean isValidTopping(String name) {
        return REGULAR_TOPPINGS.contains(name.toLowerCase()) ||
                SAUCES.contains(name.toLowerCase()) ||
                SIDES.contains(name.toLowerCase());
    }
}
