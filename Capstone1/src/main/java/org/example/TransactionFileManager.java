package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileManager {
    public static void writeFile() {
        try {
            //stablish the path to the file
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv");

            fileWriter.write("date|time|description|vendor|amount\n");
            fileWriter.write("2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50\n");
            fileWriter.write("2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00\n");

            fileWriter.close();

        }
        catch (IOException exception) {
            System.out.println("Could not find that path!");
        }
    }


    public class TransactionFileLoader {
        public static List<Transaction> readFile() {
            try {
                FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                //skip first line of list
                bufferedReader.readLine();
                String input;
                //We will add to the list as we go along:
                List<Transaction> transactionList = new ArrayList<>();
                //Tell it to read line one by one until the end of the file:
                while ((input = bufferedReader.readLine()) != null) {
                    String[] row = input.split("\\|");
                    // convert data as needed
                    try{
                        String date = row[0];
                        String time = row[1];
                        String description = row[2];
                        String vendor = row[3];
                        double amount = Double.parseDouble(row[4]);
                        //bundle the above data:
                        Transaction transaction = new Transaction(date, time, description, vendor, amount);
                        //adding to the list:
                        transactionList.add(transaction);
                    } catch (NumberFormatException ex){
                        System.out.println("Could not parse amount: "+ row[4]);
                    }

                }
                bufferedReader.close();
                return transactionList;
            } catch (IOException ex) {
                System.out.println("Failed to load csv file.");
                return new ArrayList<>();
            }
            // return transactionList;
        }
    }

}
