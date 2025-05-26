package org.example;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UserInterface {

    private Order order;
    private Scanner scanner;

    public UserInterface (){
        scanner = new Scanner(System.in);
    }
    public void homeScreen() {
        while (true) {
            System.out.println("==== Welcome to DELI-cious ====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                startNewOrder();
            } else if (choice == 0) {
                System.out.println("Thank you for your business. Have a nice day!");
                break;
            } else {
                System.out.println("invalid option. Try again.");
            }
        }
    }
    public void startNewOrder() {
        Order order = new Order(LocalDateTime.now());
        showOrderScreen(order);
    }
    public void showOrderScreen(Order order) {
        while(true){
            System.out.println("---- New Order ----");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice){
            case 1:
                order.addItem(buildSandwich());
                break;
            case 2:
                order.addItem(buildDrink());
                break;
            case 3:
                order.addItem(buildChips());
                break;
            case 4:
                checkout(order);
                break;
            case 0:
                System.out.println("Order canceled.");
                return;
            default:
                System.out.println("Invalid option");
            }
        }
    }
    private Sandwich buildSandwich(){
        return new Sandwich("My sandwhich", "white", false, 4);
    }
    private Drink

}
