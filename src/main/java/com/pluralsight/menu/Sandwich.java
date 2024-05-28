package com.pluralsight.menu;

import com.pluralsight.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private int size;
    private String bread;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(int size, String bread, List<Topping> toppings, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
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
        sb.append(size).append("\" sandwich on").append(bread).append(" bread, toasted: ").append(toasted ? "Yes" : "No").append("\nToppings:\n");

        for (Topping topping : toppings) {
            sb.append(" ").append(topping.getName()).append(" - $").append(topping.getCost(size)).append("\n");
        }
        sb.append("Total cost: $").append(calculateCost());
        return sb.toString();
    }
}
