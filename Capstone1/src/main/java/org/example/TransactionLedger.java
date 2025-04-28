package org.example;

import java.util.ArrayList;
import java.util.List;

public class TransactionLedger {

    //Call List libary and put the class Transaction and name the variable "transactions".
    //This creates a new list ready to add transactions.
    private List<Transaction> transactions = new ArrayList<>();

    public void displayTransactions(){
        for(Transaction transaction:transactions){
            System.out.println(transaction.getDate()+" "+transaction.getDescription()+" $"+transaction.getAmount()+".");
        }
    }
    public void addDepositTransaction(Transaction transaction){
        //This is to make payments, they will show up as negative
        transactions.add(transaction);
        System.out.println(transaction.getDescription()+" $-"+transaction.getAmount()+" was saved.\n");

    }
    public void addDebitTransaction(Transaction transaction){
        transactions.add(transaction);
        System.out.println(transaction.getDescription()+" $"+transaction.getAmount()+ " was saved.\n");
    }
    public double getTransactionBalance (){
        double total = 0.0;
        for(Transaction transaction : transactions){
            total += transaction.getAmount();
        }
        return total;
    }
}
