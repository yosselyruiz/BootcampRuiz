package org.example;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        this.order = new Order(LocalDateTime.now());
        showOrderScreen(this.order);
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
                Sandwich sandwich = buildSandwich();
                order.addItem(sandwich);
                break;
            case 2:
               // order.addItem(buildDrink());
                break;
            case 3:
                //order.addItem(buildChips());
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
    private Sandwich buildSandwich() {
        //Bread type
        System.out.println("Choose bread type (e.g, Wheat, White, Rye, or Wrap");
        String bread = scanner.nextLine();

        //size
        System.out.println("Choose sandwich size (4, 8, or 12 inches): ");
        int size = scanner.nextInt();
        scanner.nextLine();

        //toasted
        System.out.println("Would you like it to toasted? (Yes / No): ");
        boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");

        //create custom sandwich
        Sandwich sandwich = new Sandwich("Custom sandwich", bread, isToasted, size);
        //Add meat toppings
            System.out.println("What type of meat would you like?:\n " +
                    "(Steak/Ham/Salami/Roast Beef/Chicken/Bacon/Extra meat/No meat");
            String meat = scanner.nextLine().trim();
        System.out.println(meat + " added");
            if(!meat.equalsIgnoreCase("no meat")) {
                System.out.println("Extra meat? (yes/no): ");
                boolean isExtra = scanner.nextLine().equalsIgnoreCase("yes");

                MeatTopping meatTopping = new MeatTopping(meat, isExtra, sandwich.getSize());
                sandwich.getToppingList().add(meatTopping);
            } else {
                System.out.println("No meat added");
        }
        // Add cheese Toppings:
        System.out.println("Enter the type of cheese you want: \n" +
                "(American/Provolone/Cheddar/Swiss/No cheese)" +
                "Type 'done' to finish");
        String cheese = scanner.nextLine().trim();
        if (!cheese.equalsIgnoreCase("no cheese")) {
            System.out.print("Do you want extra cheese? (yes/no): ");
            boolean isExtra = scanner.nextLine().equalsIgnoreCase("yes");

            CheeseTopping cheeseTopping = new CheeseTopping(cheese, isExtra, sandwich.getSize());
            sandwich.getToppingList().add(cheeseTopping);
        } else {
            System.out.println("No cheese added.");
        }
        //Add regular toppings:
        addRegularTopping(sandwich,scanner);
        //Add sandwich to order:
        order.addItem(sandwich);
        return sandwich;
    }
    private void addRegularTopping(Sandwich sandwich, Scanner scanner){
        System.out.println("Add regular toppings to your sandwich.");
        System.out.println("Available: lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms");
        System.out.println("Type each topping one at a time. Type 'done' when finished:");

        List<String> validToppings = new ArrayList<>();
        validToppings.add("lettuce");
        validToppings.add("peppers");
        validToppings.add("onions");
        validToppings.add("tomatoes");
        validToppings.add("jalapeños");
        validToppings.add("cucumbers");
        validToppings.add("pickles");
        validToppings.add("guacamole");
        validToppings.add("mushrooms");

        while(true) {
            String topping = scanner.nextLine().toLowerCase();
            if(topping.equalsIgnoreCase("done")) break;

            if(validToppings.contains(topping)) {
                sandwich.getToppingList().add(new RegularTopping(topping));
                System.out.println(topping + " added");
            } else {
                System.out.println("Invalid topping. Please try again.");
            }
        }
    }

    private void checkout(Order order){
        try{
            ReceiptFileManager.printReceipt(order);
        } catch(IOException ex){
            System.out.println("Error saving receipt: " + ex.getMessage());
        }
        System.out.println("Thank you for your order!");
    }
}
