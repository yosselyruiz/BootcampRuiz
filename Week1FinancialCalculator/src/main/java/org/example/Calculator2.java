package org.example;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

//P = initial deposit
//r = annual interest rate
//t = number of years $ invested

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's calculate your daily interest rate, future value, and total interest earned. \n" +
                "Please provide your initial deposit.");
        double p = scanner.nextDouble();
        System.out.print("Enter annual interest rate. \n");
        double r = scanner.nextDouble() / 100;
        System.out.print("Enter the number of years.\n");
        double t = scanner.nextDouble();

        //assuming interest compounded/year
        double n = 365;
        //Calculate the future value FV = P(1 + r/n)^(n*t)
        double futureValue = p * Math.pow(1 + r / n, n * t);
        NumberFormat formater = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("Your future value is %s. \n", formater.format(futureValue));

        //Calculate total interest
        double totalInterest = futureValue - p;
        System.out.printf("Your total interest earned is %s. \n", formater.format(totalInterest));

    }
}
