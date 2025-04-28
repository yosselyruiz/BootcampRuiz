package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class TransactionFileWriter {
    public static void writeFile() {
        try {
            //stablish the path to the file
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv",true);

            fileWriter.write("date|time|description|vendor|amount\n");
            fileWriter.write("2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50\n");
            fileWriter.write("2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00\n");

            fileWriter.close();

        }
        catch (IOException exception) {
            System.out.println("Could not find that path!");
        }
    }
}
