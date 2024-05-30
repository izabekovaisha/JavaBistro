package com.pluralsight.toppings.classes;

import com.pluralsight.toppings.interfaces.Topping;

import java.util.List;
import java.util.Arrays;

public class PremiumTopping implements Topping {
    private String name;
    private boolean isMeat;
    private boolean isCheese;
    private boolean extraMeat;
    private boolean extraCheese;

    public static List<String> MEATS = Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon");
    public static List<String> CHEESES = Arrays.asList("american", "provolone", "cheddar", "swiss");

    public PremiumTopping(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isMeat() {
        return MEATS.contains(name);
    }

    public boolean isCheese() {
        return CHEESES.contains(name);
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    @Override
    public double getCost(int sandwichSize) {
        double price = 0.0;
        switch (sandwichSize) {
            case 4:
                price += (isMeat()) ? 1.0 : 0.0;
                price += (extraMeat) ? 0.50 : 0.0;
                price += (isCheese()) ? 0.75 : 0.0;
                price += (extraCheese) ? 0.30 : 0.0;
                break;
            case 8:
                price += (isMeat()) ? 2.0 : 0.0;
                price += (extraMeat) ? 1.0 : 0.0;
                price += (isCheese()) ? 1.50 : 0.0;
                price += (extraCheese) ? 0.60 : 0.0;
                break;
            case 12:
                price += (isMeat()) ? 3.0 : 0.0;
                price += (extraMeat) ? 1.50 : 0.0;
                price += (isCheese()) ? 2.25 : 0.0;
                price += (extraCheese) ? 0.90 : 0.0;
                break;
            default:
                break;
        }
        return price;
    }
}
