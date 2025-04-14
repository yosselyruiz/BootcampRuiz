package org.example;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
//M = P[r(1+r)^n / [(1+r)^n-1]
//r = interest rate
//p = principal
//n = loan length

public class Calculator1 {
    public static void main(String[] args) {
        //create scanner
        Scanner scanner = new Scanner(System.in);
        //Ask the user a series of questions.
        System.out.println("Hello, welcome to the mortgage loan calculator.\n" +
        "Please provide your principal.");
        double principal = scanner.nextDouble();
        System.out.print("Enter annual interest rate (e.g., 5 for 5%). \n");
        double annualInterest = scanner.nextDouble();
        System.out.print("Enter loan years. \n");
        double loanLength = scanner.nextDouble();
        // Calculate # of monthly payments

        double months = loanLength * 12;
        System.out.printf("Your total monthly payments are: %.0f \n", months);
        //Calculate the monthly interest rate
        double monthlyInterestRate = (annualInterest/100)/12;
        System.out.printf("Here is your monthly interest rate %.3f \n ", monthlyInterestRate);
        //M = Principal[monthlyInterestRate(1+)^loanLength / [(1+monthlyInterestRate)^loanLength-1]
        //divide formula, left and right
        double monthlyPayment = principal*(monthlyInterestRate * Math.pow(1+monthlyInterestRate, months))
      / (Math.pow(1+monthlyInterestRate, months)-1);
        //double monthlyPayment = left/right;

        NumberFormat formater = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("Your monthly payment is %s.\n", formater.format(monthlyPayment));
        //calculate the total interest paid
        double totalPaid = months * monthlyPayment;
        double totalInterestPaid = totalPaid - principal;
       System.out.printf("Your total interest paid is %s.", formater.format(totalInterestPaid));





    }
}