package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReceiptFileManager {

    //private static final String RECEIPT_PATH = "src/main/resources/receipt.csv";

    public static void printReceipt (Order order) throws IOException {

        String receiptFile = "receipt.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFile))) {
            //write to file
            writer.write("====== DELI -cious Receipt ======");
            writer.write("Order date: " + order.getDateTime() + "\n");
            //also print to console
            System.out.println("====== DELI -cious Receipt ======");
            System.out.println("Order date: " + order.getDateTime());
            System.out.println();

            List<PricedItem> items = order.getItem();
            double total = 0.0;

            for (PricedItem item : items) {
                writer.write(item.getName() + "\n");
                System.out.println(item.getName());

                //if item is a sandwich, show the toppings
                if (item instanceof Sandwich) {
                    Sandwich sandwich = (Sandwich) item;
                    writer.write(sandwich.toString() + "\n");
                    System.out.println(sandwich);
                }
                double price = item.getPrice();
                total += price;
                writer.write(String.format("  Price: $%.2f%n", price));
                // System.out.println("Price: $%.2f%n", price);//
            }
            writer.write(String.format("TOTAL: $%.2f$n", total));
            writer.write("====================================\n");
        } catch (IOException ex) {
            System.out.println("Error writing receipt to file: " + ex.getMessage());
        }
    }
}
