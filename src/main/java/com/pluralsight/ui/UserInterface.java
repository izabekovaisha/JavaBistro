package com.pluralsight.ui;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Java Bistro!");
            System.out.println("1. New order");
            System.out.println("0. Exit");
            System.out.println("Please select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    break;
                case 2:

            }
        }
    }
}
