package com.pluralsight.services;

import com.pluralsight.orders.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private String RECEIPTS_FOLDER = "receipts/";

    public void generateReceipt(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String filename = RECEIPTS_FOLDER + timestamp + ".txt";

        File folder = new File(RECEIPTS_FOLDER);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (!created) {
                System.out.println("Failed to create receipts folder.");
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Order details:\n");
            writer.write(order.toString() + "\n");
            System.out.println("Receipt generated successfully: " + filename);
        } catch (IOException e) {
            System.err.println("Error generating receipt: " + e.getMessage());
        }
    }
}
