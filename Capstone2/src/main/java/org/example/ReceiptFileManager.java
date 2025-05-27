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
            //System.out.println(order.orderSummary(order));
        } catch (IOException ex) {
            System.out.println("Error writing receipt to file: " + ex.getMessage());
        }
    }
}
