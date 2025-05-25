package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptFileManager {

    //private static final String RECEIPT_PATH = "src/main/resources/receipt.csv";

    public static void saveReceipt (Order order) throws IOException {
        try(FileWriter writer = new FileWriter(RECEIPT_PATH, true)){
            for(Order or){
        }
    }
}
