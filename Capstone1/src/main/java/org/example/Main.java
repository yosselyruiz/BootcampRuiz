package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
            TransactionLedger transactionLedger = new TransactionLedger();

            //Load transactions from the file when the app starts:
            transactionLedger.loadTransactionsFromFile();

        while (true) {
            System.out.println("\nMain Menu \n");
            System.out.println("1) Display ALL transactions.");
            System.out.println("2) Add Deposit.");
            System.out.println("3) Make payment.");
            System.out.println("4) Search transactions.");
            System.out.println("5) Exit \n");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    displayTransactions(scanner,transactionLedger);
                    break;
                case 2:
                    addDepositTransaction(scanner,transactionLedger);
                    break;
                case 3:
                    addDebitTransaction(scanner,transactionLedger);

                    break;
                case 4:
                    searchTransactions(scanner,transactionLedger);
                    break;
                case 5:
                    System.exit(0);
            }
        }

    }

    public static void displayTransactions(Scanner scanner, TransactionLedger transactionLedger) {
        try {
            System.out.println("Here is the list of transactions: \n");
            System.out.println("Date|Description|Vendor|Amount");
            List<Transaction> transactions = transactionLedger.getTransactions();
            //Loops through the transactions array and displays all the transactions:
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getDate() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|$" + transaction.getAmount());
            }
            System.out.println("\nEnter 0 to return to the main menu.");
            String input = scanner.nextLine();
            if (input.equals("0")) {
            }
        } catch (Exception ex) {
            System.out.println("Failed to read transactions.");
            ex.printStackTrace();
        }
    }
    public static void addDepositTransaction(Scanner scanner, TransactionLedger transactionLedger) {
        try {
            System.out.println("Please enter the amount of your deposit.");
            scanner.nextLine();
            String userDeposit = scanner.nextLine();
            double amount = Double.parseDouble(userDeposit);

            if (amount <= 0) {
                System.out.println("Deposit must be greater than $0.");
                return ;
            }
            //Get time and date (current)
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();

            System.out.println("Enter the description: ");
            String description = scanner.nextLine();

            System.out.println("Enter the vendor: ");
            String vendor = scanner.nextLine();

           //Create the transaction object
            Transaction deposit = new Transaction(currentDate,currentTime, description, vendor,amount);

            //add deposit transaction to the ledger:
            transactionLedger.addDepositTransaction(deposit);
            //save to file:
            TransactionFileManager.writeToFile(deposit);
            System.out.println("Deposit successful!");

        } catch (NumberFormatException ex) {
            System.out.println("Invalid entry. Please enter a valid amount.");

        } catch (Exception ex) {
            System.out.println("An error has occurred while processing the deposit. Please try again.");
            ex.printStackTrace();
        }
    }
    public static void addDebitTransaction(Scanner scanner, TransactionLedger transactionLedger){
        try {
            System.out.println("Please enter the amount of your payment: ");
            scanner.nextLine();
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println("Payment amount must be greater than $0.");
                return;
            }
            else {
                //convert to negative # for a payment transaction:
                amount *= -1;

                LocalDate currentDate = LocalDate.now();
                LocalTime currentTime = LocalTime.now();

                System.out.println("Enter the description:");
                String description = scanner.nextLine();

                System.out.println("Enter the vendor:");
                String vendor = scanner.nextLine();

                //Create the transaction:
                Transaction debit = new Transaction(currentDate, currentTime, description, vendor, amount);

                //add to ledger:
                transactionLedger.addDebitTransaction(debit);
                //save to file:
                TransactionFileManager.writeToFile(debit);

                System.out.println("Payment was successful!");
            }
        } catch (NumberFormatException ex){
            System.out.println("Invalid entry. Please enter ONLY numbers. No special characters.");
            System.out.println("An error occurred while processing the payment.");
            ex.printStackTrace();
        }
    }
    public static void searchTransactions (Scanner scanner, TransactionLedger transactionLedger){
        System.out.println("Please enter the type of transaction you want to search : 1) deposit or 2) debit.\n");
        int type = scanner.nextInt();

        //Look through the list:
        List<Transaction> results;

        switch (type){
            case 1:
            results = transactionLedger.getDeposits();
                System.out.println("Here is the list of your deposits: \n");
                break;
            case 2:
                results = transactionLedger.getDebits();
                System.out.println("Here is the list of your debits: \n");
                break;
            default:
                System.out.println("Invalid input. Please enter debit or deposit.");
                return;
            }
        if (results.isEmpty()) {
            System.out.println("No transactions found for this type.");
        //Here, it is where it actually gives me the results!
        } else {
            System.out.println("Date | Description | Vendor | Amount");
            for (Transaction t : results) {
                System.out.printf("%s | %s | %s | $%.2f%n", t.getDate(), t.getDescription(), t.getVendor(), t.getAmount());
              //Here, it ended early:  return;

            }
        }

        System.out.println("\nEnter 0 to return to the main menu.");
        scanner.nextInt(); // Wait for input before returning
    }
        }
