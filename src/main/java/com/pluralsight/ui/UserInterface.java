package com.pluralsight.ui;

import com.pluralsight.menu.classes.Chips;
import com.pluralsight.menu.classes.Drink;
import com.pluralsight.menu.classes.Sandwich;
import com.pluralsight.orders.Customer;
import com.pluralsight.orders.Order;
import com.pluralsight.toppings.classes.PremiumTopping;
import com.pluralsight.toppings.classes.RegularTopping;
import com.pluralsight.toppings.interfaces.Topping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    private Order currentOrder;

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.displayHomeScreen();
    }

    private void displayHomeScreen() {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to Java Bistro!");
            System.out.println("1. New order");
            System.out.println("0. Exit");
            System.out.println("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    startNewOrder();
                    break;
                case 0:
                    System.out.println("Exiting application. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void startNewOrder() {
        System.out.println("Enter customer first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter customer last name:");
        String lastName = scanner.nextLine();
        Customer customer = new Customer(firstName, lastName);

        currentOrder = new Order(customer, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        displayOrderScreen();
    }

    private void displayOrderScreen() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("Order screen:");
            System.out.println("1) Add sandwich");
            System.out.println("2) Add drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel order");
            System.out.println("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    break;
                case 0:
                    cancelOrder();
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addSandwich() {
        System.out.println("Add sandwich:");

        System.out.println("Select type of bread:");
        for (int i = 0; i < Sandwich.BREAD_TYPES.size(); i++) {
            System.out.println((i + 1) + ") " + Sandwich.BREAD_TYPES.get(i));
        }
        System.out.println("Choose an option: ");
        String bread = Sandwich.BREAD_TYPES.get(scanner.nextInt() - 1);
        scanner.nextLine();

        System.out.println("Enter sandwich size (4/8/12 inches)");
        int size = scanner.nextInt();
        scanner.nextLine();

        List<Topping> toppings = new ArrayList<>();
        toppings.addAll(selectToppings("meat", PremiumTopping.MEATS));
        toppings.addAll(selectToppings("cheese", PremiumTopping.CHEESES));
        toppings.addAll(selectToppings("regular", RegularTopping.REGULAR_TOPPINGS));
        toppings.addAll(selectToppings("sauce", RegularTopping.SAUCES));
        toppings.addAll(selectToppings("sides", RegularTopping.SIDES));

        System.out.println("Would you like your sandwich toasted (yes/no)? ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toppings, toasted);
        currentOrder.addSandwich(sandwich);
        System.out.println("Sandwich added to your order.");
    }

    private List<Topping> selectToppings(String category, List<String> availableToppings) {
        List<Topping> selectedToppings = new ArrayList<>();

        System.out.println("Select " + category + "toppings: ");
        for (String topping : availableToppings) {
            System.out.println(topping + ", ");
        }
        System.out.println();

        String input = scanner.nextLine();
        String[] toppingsNames = input.split(",");

        for (String toppingName : toppingsNames) {
            String trimmedToppingName = toppingName.trim();
            if (availableToppings.contains(trimmedToppingName)) {
                selectedToppings.add(new RegularTopping(trimmedToppingName));
            } else {
                System.out.println("Invalid topping: " + trimmedToppingName);
            }
        }
        return selectedToppings;
    }

    private void addDrink() {
        System.out.println("Add drink:");
        System.out.println("Select drink size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.println("Choose an option: ");
        int drinkSizeOption = scanner.nextInt();
        scanner.nextLine();

        String drinkSize = "";
        switch (drinkSizeOption) {
            case 1:
                drinkSize = "Small";
                break;
            case 2:
                drinkSize = "Medium";
                break;
            case 3:
                drinkSize = "Large";
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
        System.out.println("Select drink flavor:");
        System.out.println("1) Papaya green tea");
        System.out.println("2) Agave lemonade");
        System.out.println("3) Unsweetened iced tea");
        System.out.println("Choose an option: ");
        int drinkFlavorOption = scanner.nextInt();
        scanner.nextLine();

        String drinkFlavor = "";
        switch (drinkFlavorOption) {
            case 1:
                drinkFlavor = "Papaya green tea";
                break;
            case 2:
                drinkFlavor = "Agave lemonade";
                break;
            case 3:
                drinkFlavor = "Unsweetened iced tea";
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
                return;
        }
        Drink drink = new Drink(drinkFlavor, drinkSize);
        currentOrder.addDrink(drink);
        System.out.println(drinkSize + " " + drinkFlavor + "drink added to your order.");
    }

    private void addChips() {
        System.out.println("Add chips:");
        System.out.println("Select chip size:");
        System.out.println("1) Sour cream & onion");
        System.out.println("2) Barbecue");
        System.out.println("3) Cheddar cheese");
        System.out.println("Choose an option: ");
        int chipsTypeOption = scanner.nextInt();
        scanner.nextLine();

        String chipsType = "";
        switch (chipsTypeOption) {
            case 1:
                chipsType = "Sour cream & onion";
                break;
            case 2:
                chipsType = "Barbecue";
                break;
            case 3:
                chipsType = "Cheddar cheese";
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
                return;
        }
        Chips chips = new Chips(chipsType, 1.50);
        currentOrder.addChips(chips);
        System.out.println(chipsType + "chips added to your order.");
    }

    private void checkout() {
        System.out.println("Checkout:");
        System.out.println(currentOrder);
        System.out.println("Confirm order? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Order confirmed.");
            currentOrder = null;
            displayHomeScreen();
        } else {
            System.out.println("Order not confirmed. Returning to home screen.");
            displayHomeScreen();
        }
    }

    private void cancelOrder() {
        currentOrder = null;
        System.out.println("Order canceled. Returning to home screen.");
        displayHomeScreen();
    }
}


