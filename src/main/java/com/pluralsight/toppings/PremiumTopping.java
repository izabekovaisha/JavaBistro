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
        return name;
    }

    @Override
    public double getCost(int sandwichSize) {
        double premiumToppingPrice;
        switch (sandwichSize) {
            case 4:
                premiumToppingPrice = price;
            case 8:
                premiumToppingPrice = price * 2;
        }
    }
}
