package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileManager {

    public static List<Transaction> readFile() {
        List<Transaction> transactionsList = new ArrayList<>();
        String filePath = "src/main/resources/transactions.csv";
        File file = new File(filePath);

        //Make sure the folder exists:
        File folder = file.getParentFile();
        if (!folder.exists() || file.length() == 0) {
            System.out.println("Transaction file not found or is empty.");
            return transactionsList;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String input;
            bufferedReader.readLine();
            //Open file in append mode:
            FileWriter writer = new FileWriter(file, true);
            writer.write("date|time|description|vendor|amount\n");
            //Write a header if it's a new or empty file:
            while ((input = bufferedReader.readLine()) != null) {
                if (input.trim().isEmpty()) continue;

                try {
                    transactionsList.add(Transaction.fromCSV(input));
                } catch (Exception ex) {
                    System.out.println("Skipping invalid line: " + input);
                }
            }
        } catch (IOException ex) {
            System.out.println("Failed to load csv file");
            ex.printStackTrace();
        }
        return transactionsList;
    }

    public static void writeToFile(Transaction transaction) {
        String filePath = "src/main/resources/transactions.csv";
        File file = new File(filePath);

        try {
            //make sure the folder exists:
            File folder = file.getParentFile();
            if (!folder.exists()) {
                folder.mkdirs();
            }
            boolean fileExists = file.exists();
            boolean isEmpty = !fileExists||file.length()==0;
            //Open file in write mode(
            FileWriter writer = new FileWriter(file, true);

            //write header:
            if (isEmpty) {
                writer.write("date|time|description|vendor|amount\n");
            }
            //write each transaction from the list to the file:

                writer.write(transaction.toString() + "\n");

            writer.close();
            System.out.println("All transactions have been written in the file.");
        } catch (IOException ex) {
            System.out.println("Error occurred while writing transactions to the file.");
            ex.printStackTrace();
        }
    }
}