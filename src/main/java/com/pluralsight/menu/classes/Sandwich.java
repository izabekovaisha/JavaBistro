package com.pluralsight.menu.classes;

import com.pluralsight.toppings.classes.PremiumTopping;
import com.pluralsight.toppings.classes.RegularTopping;
import com.pluralsight.toppings.interfaces.Topping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sandwich {
    private int size;
    private String bread;
    private List<Topping> toppings;
    private boolean toasted;

    public static List<String> BREAD_TYPES = Arrays.asList("white", "wheat", "rye", "wrap");

    public Sandwich(int size, String bread, List<Topping> toppings, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = new ArrayList<>(toppings);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calculateCost() {
        double basePrice = 0;

        switch (size) {
            case 4:
                basePrice = 5.50;
                break;
            case 8:
                basePrice = 7.00;
                break;
            case 12:
                basePrice = 8.50;
                break;
        }
        double toppingsPrice = 0;
        for (Topping topping : toppings) {
            toppingsPrice += topping.getCost(size);
        }
        return basePrice + toppingsPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size: ").append(size).append("\n");
        sb.append("Bread: ").append(bread).append("\n");
        sb.append("Toasted: ").append(toasted ? "Yes" : "No").append("\n");
        sb.append("Toppings: ");
        if (toppings.isEmpty()) {
            sb.append("None");
        } else {
            for (Topping topping : toppings) {
                sb.append(topping.getName()).append(" - $").append(topping.getCost(size));
                if (topping instanceof PremiumTopping) {
                    PremiumTopping premiumTopping = (PremiumTopping) topping;
                    sb.append(" | Extra meat: ").append(premiumTopping.isExtraMeat() ? "Yes" : "No");
                    sb.append(" | Extra cheese: ").append(premiumTopping.isExtraCheese() ? "Yes" : "No");
                }
                sb.append(" | ");
            }
        }
        sb.append("\nPrice: $").append(calculateCost());
        return sb.toString();
    }
}