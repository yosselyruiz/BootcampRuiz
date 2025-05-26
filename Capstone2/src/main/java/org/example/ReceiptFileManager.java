package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptFileManager {

    //private static final String RECEIPT_PATH = "src/main/resources/receipt.csv";

    public static void printReceipt (Order order) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = order.getDateTime().format(formatter);
        String receiptFile = "receipt " + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFile))) {
            //write to file
            writer.write("====== DELI -cious Receipt ======");
            writer.write("Order date: " + timestamp + "\n");
            System.out.println("====== DELI -cious Receipt ======");
            System.out.println("Order date: \" + timestamp + \"\\n");

            List<PricedItem> items = order.getItem();
            double total = 0.0;

            for (PricedItem item : items) {
                writer.write(item.getName() + "\n");
                System.out.println(item.getName());

                //if item is a sandwich, show the toppings
                if (item instanceof Sandwich) {
                    Sandwich sandwich = (Sandwich) item;
                    writer.write(sandwich.toString() + "\n");
                    System.out.println(sandwich.toString());
                }
                double price = item.getPrice();
                total += price;
                writer.write(String.format("  Price: $%.2f%n", price));
                writer.write("");
                System.out.printf("Price: $%.2f%n", price);
                System.out.println("====================================\n");
            }
            //Footer
            writer.write(String.format("TOTAL: $%.2f%n", total));
            writer.write("====================================\n");
            System.out.printf("TOTAL: $%.2f%n", total);
            System.out.println("====================================");
        } catch (IOException ex) {
            System.out.println("Error writing receipt to file: " + ex.getMessage());
        }
    }
}
