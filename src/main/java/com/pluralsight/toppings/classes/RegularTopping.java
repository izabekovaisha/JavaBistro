package com.pluralsight.toppings.classes;

import com.pluralsight.toppings.interfaces.Topping;

import java.util.List;
import java.util.Arrays;

public class RegularTopping implements Topping {
    private String name;
    public static List<String> REGULAR_TOPPINGS = Arrays.asList("lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms");
    public static List<String> SAUCES = Arrays.asList("mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette");
    public static List<String> SIDES = Arrays.asList("au jus", "sauce");

    public RegularTopping(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost(int sandwichSize) {
        return 0.0;
    } // Regular toppings have no cost, so return 0.0
}