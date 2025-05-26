package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private List<PricedItem> items;
    private LocalDateTime dateTime;
    private List<Topping> toppingList;

    public Order(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.items = new ArrayList<>();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<PricedItem> getItem() {
        return items;
    }
    public void addTopping(Topping topping){
        toppingList.add(topping);
    }
    public boolean removeTopping (String name){
        return toppingList.removeIf(t -> t.getName().equalsIgnoreCase(name));
    }

    public void addItem(PricedItem item){
        items.add(item);
    }
    public boolean removeItem(String itemName) {
        if(items.isEmpty()){
            System.out.println("Your order is currently empty.");
            return false;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the item you want to remove: \n");
        for(int i = 0; i < items.size(); i++) {
            PricedItem item = items.get(i);
            System.out.println((i + 1) + ". " + items.get(i).toString());
        }
        System.out.println("Which item would you like to remove?");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
            if(index < 0 || index >= items.size()){
                System.out.println("Invalid number");
                return false;
            }
            PricedItem selectedItem = items.get(index);
            if(selectedItem instanceof Sandwich || selectedItem instanceof Chips || selectedItem instanceof Drink){
                System.out.println(selectedItem.toString());
                System.out.println("Type yes to remove.");
                String input = scanner.nextLine();

                if(input.equalsIgnoreCase("yes")){
                    items.remove(index);
                    System.out.println("item removed");
                }
        }
        return false;
    }

    //Helper method for orderSummary
    public double getTotal(){
        double total = 0.0;
        for(PricedItem item : items){
            total += item.getPrice();
        }
        return total;
    }
    public void orderSummary(){
        System.out.println("Oder placed on: " + dateTime);
        System.out.println("Here is your order summary: ");
        double total = 0.0;
        for(PricedItem item : items){
            System.out.println("- " + item.getName());

            if(item instanceof Sandwich sandwich){
                System.out.println(sandwich.getBreadType() + sandwich.getSize() +
                        sandwich.getPrice() + sandwich.isToasted());
                for(Topping topping : sandwich.getToppingList()){
                    String extraTopping = "";
                    if(topping instanceof MeatTopping){
                        extraTopping = ((MeatTopping) topping).isExtra() ? " (extra)" : "";
                    }
                    else if (topping instanceof CheeseTopping){
                        extraTopping = ((CheeseTopping) topping).isExtra() ? " (extra)" : "";
                    }
                    System.out.println("   - " + topping.getName() + extraTopping);
                }
            }
            if(item instanceof Chips){
                System.out.println("Chips: ");
            }
            if(item instanceof  Drink drink){
                System.out.println("    Drink size: " + drink.getSize());
            }
            double price = item.getPrice();
            System.out.printf(" Price: $%.2f%n%n", price);
            total += price;
        }
        System.out.println("TOTAL: $%.2f%n, total");
    }
}
