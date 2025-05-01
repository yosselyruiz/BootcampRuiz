package org.example;

import java.util.ArrayList;
import java.util.List;

public class TransactionLedger {

    //Call List library and put the class Transaction and name the variable "transactions".
    private List<Transaction> transactions;
    //This creates a new list ready to add transactions.
    public TransactionLedger(){
        this.transactions = new ArrayList<>();
    }
    public void addDepositTransaction(Transaction transaction){
        //This is to make payments, they will show up as negative
       if(transaction.getAmount() > 0){
           transactions.add(transaction);
           System.out.println(transaction.getDescription()+" $"+transaction.getAmount()+" was saved.\n");
       } else {
           System.out.println("Amount must be greater than $0. \n");
       }
    }
    public void addDebitTransaction(Transaction transaction) {

        if (transaction.getAmount() < 0) {
            transactions.add(transaction);
            System.out.println(transaction.getDescription() + " payment for $" + transaction.getAmount() + " was saved.\n");
        } else {
            System.out.println("Amount must be greater than $0. \n");
        }
    }
    public List<Transaction> getTransactions(){
      return transactions;
    }
    public void loadTransactionsFromFile(){
        //used to load saved transactions when program starts up.
        List<Transaction> loadedTransactions = TransactionFileManager.readFile();
        transactions.addAll(loadedTransactions);
    }
    public List<Transaction> getDeposits(){
        List<Transaction> deposits = new ArrayList<>();
        for (Transaction t : transactions){
            if(t.getAmount()> 0){
                deposits.add(t);
            }
        }
        return deposits;
    }
    public List<Transaction> getDebits(){
        List<Transaction> debits = new ArrayList<>();
        for(Transaction t : transactions){
            if(t.getAmount() < 0 ){
                debits.add(t);
            }
        }
        return debits;
    }
}
