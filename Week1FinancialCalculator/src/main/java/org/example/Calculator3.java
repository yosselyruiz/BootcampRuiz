package org.example;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) {
//Accept the monthly payout amount (PMT), //
// expected interest rate (r),
// and number of years to pay out (t) from the user as input.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide your monthly payout amount");
        double pmt = scanner.nextDouble();
        System.out.println("Please provide interest rate");
        double r = scanner.nextDouble();
        System.out.println("Please provide number of years to payout");
        double t = scanner.nextDouble();

        //Calculate the monthly interest rate (r) by dividing
        //the annual interest rate by 12, dividing by 100 to convert it to a decimal.
        double monthlyInterestRate = (r / 12) / 100;
        System.out.printf("Your monthly interest rate is %.3f. \n", monthlyInterestRate);

        //Calculate the total number of monthly payments (n) by multiplying the number
        // of years to pay out by 12
        double n = t * 12;
        System.out.printf("Your total number of monthly payments is %.0f. \n", n);

        //Use the formula to calculate the present value (PV) of the annuity.
        //Formula: PV = PMT × [(1 - (1 + r)^(-n)) / r]
        //PV is the present value of the annuity.
        //PMT is the monthly payout amount.
        //r is the monthly interest rate (annual interest rate divided by 12 and then
        // divided by 100 to convert to a decimal). n is the total number of monthly payments
        //(number of years to pay out multiplied by 12).

       // double pv = pmt * Math.pow(1 - (1 + monthlyInterestRate), (-n) / r);
        double pv = pmt * ((1 - Math.pow(1 + monthlyInterestRate, -n)) / monthlyInterestRate);
        NumberFormat formater = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("Here is your present value %s. \n", formater.format(pv));

    }
}
