package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //set up the scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String userInput = scanner.nextLine();
        System.out.println("Hi there " + userInput);
        //Ask the user for 2 numbers and show the result.
        System.out.println("Give me two whole numbers");
        int numberOne = scanner.nextInt();
        int numberTwo = scanner.nextInt();
        //Set up the calculation of both numbers.
        //System.out.println("Your numbers are " + (numberOne + numberTwo) + ".");

        //Add the next scanner because we are asking another question to use.
        scanner.nextLine();
        System.out.println("Pick an operation by inputting the first letter of the operation");
        String operation = scanner.nextLine();
        switch (operation){
            case "A":
                System.out.println("Your total is " + (numberOne + numberTwo) + ".");
                break;
            case "S":
                System.out.println("You total is " + (numberOne-numberTwo + "."));
                break;
            case "M":
                System.out.println("You total is " + (numberOne*numberTwo));
                break;
            case "D":
                System.out.println("Your numbers divided equal to " + (numberOne / numberTwo));
                break;
            default:
                System.out.println("I'm not sure about that sign");
                break;
        }

    }

}