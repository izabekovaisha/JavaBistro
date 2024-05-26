package com.pluralsight.menu;

import com.pluralsight.toppings.Topping;

import java.util.List;

public class Sandwich {
    private int size;
    private String bread;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(int size, String bread, List<Topping> toppings, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
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
        double totalCost = 0;

        switch (size) {
            case 4:
                totalCost += 5.50;
            case 8:
                totalCost += 7.00;
            case 12:
                totalCost += 8.50;
                break;
        }
        for (Topping topping : toppings) {
            totalCost += topping.getCost(size);
        }
        return totalCost;
    }
}
