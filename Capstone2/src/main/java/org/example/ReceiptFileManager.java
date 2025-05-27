package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {


    public static void printReceipt (Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd at HH:mm");
        String timestamp = order.getDateTime().format(formatter);
        String receiptFile = "receipt " + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(receiptFile))) {
            //write to file
            writer.write("====== DELI -cious Receipt ======");
        } catch (IOException ex) {
            System.out.println("Error writing receipt to file: " + ex.getMessage());
        }
    }
}
