package org.example;

import java.util.ArrayList;
import java.util.List;

public class TransactionLedger {
    private List<Transaction> transactions = new ArrayList<>();

    public void displayTransactions(){
        for(Transaction transaction:transactions){
            System.out.println(transaction.getDate()+" "+transaction.getDescription()+" $"+transaction.getAmount()+".");
        }
    }
    public void addDepositTransaction(Transaction transaction){
        transactions.add(transaction);
        System.out.println(transaction.getDescription()+" $"+transaction.getAmount()+" was saved.\n");

    }
    public void addDebitTransaction(Transaction transaction){
        transactions.add(transaction);
        System.out.println(transaction.getDescription()+" $"+transaction.getAmount()+ " was saved.\n");
    }


}
