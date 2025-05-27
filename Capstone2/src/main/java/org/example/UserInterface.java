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
            System.out.println("2) Menu");
            System.out.println("0) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                startNewOrder();
            }
            else if(choice == 2){
                System.out.println("""
╔════════════════════════════════════════════════════╗
║                  DELI-cious Menu                   ║
╠════════════════════════════════════════════════════╣
║  Sandwich Options                                  ║
║  • Bread: White, Wheat, Rye, Wrap                  ║
║  • Sizes: 4" ($5.50), 8" ($7.00), 12" ($8.50)      ║
║  • Toasted: Yes / No                               ║
║                                                    ║
║  • Meats:                                          ║
║    - 4": $1.00   + Extra: $0.50                    ║
║    - 8": $2.00   + Extra: $1.00                    ║
║    - 12": $3.00  + Extra: $1.50                    ║
║    Types: Steak, Ham, Salami, Roast Beef,          ║
║           Chicken, Bacon                           ║
║                                                    ║
║  • Cheese:                                         ║
║    - 4": $0.75   + Extra: $0.30                    ║
║    - 8": $1.50   + Extra: $0.60                    ║
║    - 12": $2.25  + Extra: $0.90                    ║
║    Types: American, Provolone, Cheddar, Swiss      ║
║                                                    ║
║  • Regular Toppings (Included):                    ║
║    Lettuce, Peppers, Onions, Tomatoes,             ║
║    Jalapeños, Cucumbers, Pickles, Guacamole,       ║
║    Mushrooms                                       ║
║                                                    ║
║  • Sauces (Included):                              ║
║    Ketchup, Ranch, Thousand Islands,               ║
║    Vinaigrette, Mayo, Mustard                      ║
║  • Sauces (Included):                              ║ 
║    Au jus, Sauce                                   ║
╠════════════════════════════════════════════════════╣
║  Drinks                                            ║
║  • Small  - $2.00                                  ║
║  • Medium - $2.50                                  ║
║  • Large  - $3.00                                  ║
╠════════════════════════════════════════════════════╣
║  Chips                                             ║
║  • All varieties - $1.50                           ║
╠════════════════════════════════════════════════════╣
║              Thank you for coming!                 ║
╚════════════════════════════════════════════════════╝
""");
            }
            else if (choice == 0) {
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
                buildSandwich();
                break;
            case 2:
               addDrink();
                break;
            case 3:
                addChip();
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
        System.out.println("Choose bread type (e.g, Wheat, White, Rye, or Wrap)");
        String bread = scanner.nextLine();

        //size
        System.out.println("Choose sandwich size (4, 8, or 12 inches): ");
        int size = scanner.nextInt();
        scanner.nextLine();

        //toasted
        System.out.println("Would you like it to toasted? (Yes / No): ");
        boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");

        //create custom sandwich
        Sandwich sandwich = new Sandwich("Sandwich", bread, isToasted, size);
        //Add meat toppings
            System.out.println("What type of meat would you like?:\n " +
                    "(Steak/Ham/Salami/Roast Beef/Chicken/Bacon/Extra meat/No meat");
            String meat = scanner.nextLine().trim();
        System.out.println(meat + " added");
            if(!meat.equalsIgnoreCase("no meat")) {
                System.out.println("Extra meat? (yes/no): ");
                boolean isExtra = scanner.nextLine().equalsIgnoreCase("yes");

                MeatTopping meatTopping = new MeatTopping(meat, isExtra, sandwich.getSize());
                sandwich.addTopping(meatTopping);
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
            sandwich.addTopping(cheeseTopping);
        } else {
            System.out.println("No cheese added.");
        }
        //Add regular toppings:
        addRegularTopping(sandwich,scanner);
        //Add sandwich to order:
        order.addItem(sandwich);
        return sandwich;
    }
    private void addDrink() {
        System.out.println("What size drink would you like? \n" +
                "1) Small , 2) Medium, or 3) Large");
        int size = scanner.nextInt();
        scanner.nextLine();
        String name = switch (size) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> {
                System.out.println("Invalid size. Defaulting to Small Drink.");
                yield "Small Drink";
            }
        };
        Drink drink = new Drink(name, size);
        order.addItem(drink);
        System.out.println("Drink added to your order.");
    }
    private void addChip(){
        System.out.println("Would you like chips? (Yes / No)");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("yes")){
            String name = "Chips";
            Chips chipChoice = new Chips(name,true);
            order.addItem(chipChoice);
            System.out.println("Chips added to your order.");
        } else {
            System.out.println("No chips added.");
        }
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
        System.out.println(order.orderSummary(order));
    }
}
