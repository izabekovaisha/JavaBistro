package com.pluralsight.toppings;

import java.util.List;
import java.util.Arrays;

public class PremiumTopping implements Topping {
    private String name;
    private boolean isMeat;
    private boolean isCheese;
    private boolean extraMeat;
    private boolean extraCheese;

    private List<String> MEATS = Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon");
    private List<String> CHEESES = Arrays.asList("american", "provolone", "cheddar", "swiss");

    public PremiumTopping(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isMeat() {
        return isMeat;
    }

    public boolean isCheese() {
        return isCheese;
    }

    @Override
    public double getCost(int sandwichSize) {
        double price = 0.0;
        switch (sandwichSize) {
            case 4:
                price += (isMeat()) ? 1.0 : 0.0; // Add $1.00 for meats
                price += (extraMeat) ? 0.50 : 0.0; // Add $0.50 for extra meat
                price += (isCheese()) ? 0.75 : 0.0; // Add $1.00 for meats
                price += (extraCheese) ? 0.30 : 0.0; // Add $0.50 for extra meat
                break;
            case 8:
                price += (isMeat()) ? 2.0 : 0.0; // Add $2.00 for meats
                price += (extraMeat) ? 1.0 : 0.0; // Add $1.00 for extra meat
                price += (isCheese()) ? 1.50 : 0.0; // Add $2.00 for meats
                price += (extraCheese) ? 0.60 : 0.0; // Add $1.00 for extra meat
                break;
            case 12:
                price += (isMeat()) ? 3.0 : 0.0; // Add $3.00 for meats
                price += (extraMeat) ? 1.50 : 0.0; // Add $1.50 for extra meat
                price += (isCheese()) ? 2.25 : 0.0; // Add $3.00 for meats
                price += (extraCheese) ? 0.90 : 0.0; // Add $1.50 for extra meat
                break;
            default:
                break;
        }
        return price;
    }
}
