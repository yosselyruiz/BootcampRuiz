package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransactionFileManager.writeFile();

        //Call the cvs loading
        List<Transaction> transactions = TransactionFileManager.TransactionFileLoader.readFile();
        Scanner scanner = new Scanner(System.in);
        //Instantiate the Transaction class:
        TransactionLedger transactionLedger = new TransactionLedger();

        while (true) {
            System.out.println("\nMain Menu \n");
            System.out.println("1) Display ALL transactions.");
            System.out.println("2) Add Deposit.");
            System.out.println("3) Make payment.");
            System.out.println("4) Exit \n");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    displayAllTransactions(scanner, transactionLedger);
                    break;
                case 2:
                    System.out.println("Please enter your deposit amount: \n$");
                    //transaction.
                    break;
                case 3:
                    System.out.println("Please enter your payment amount: \n$");

                    break;
                case 4:
                    System.exit(0);
            }
        }

    }

    public static void displayAllTransactions(Scanner scanner, TransactionLedger transactionLedger) {
        try {
            System.out.println("Here is the list of transactions: \n");
            List<Transaction> transactions = TransactionFileManager.TransactionFileLoader.readFile();
            //Loops through the transactions array and displays all the transactions:
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getDate() + " " + transaction.getDescription() + " " + transaction.getVendor() + " $" + transaction.getAmount());
            }
        } catch (Exception ex) {
            System.out.println("Failed to read transactions.");
            ex.printStackTrace();
        }
    }
}