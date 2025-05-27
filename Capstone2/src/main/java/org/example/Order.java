package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public String orderSummary(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm \n");
        String timestamp = order.getDateTime().format(formatter);
        String receipt = "receipt " + timestamp;
        StringBuilder sb = new StringBuilder();
            sb.append("Order placed on: ").append(receipt);
            sb.append("Here is your order summary:\n");
            double total = 0.0;
            for (PricedItem item : items) {
                if (item instanceof Sandwich sandwich) {
                    sb.append(String.format(" %s on %s, %d\"%s\n",
                            sandwich.getName(),
                            sandwich.getBreadType(),
                            sandwich.getSize(),
                            sandwich.isToasted() ? ", Toasted" : "Not Toasted"));
                    for (Topping topping : sandwich.getToppingList()) {
                        String extraTopping = "";
                        if (topping instanceof MeatTopping && ((MeatTopping) topping).isExtra())  {
                            extraTopping =  " (extra)";
                        } else if (topping instanceof CheeseTopping cheeseTopping && cheeseTopping.isExtra()) {
                            extraTopping = ((CheeseTopping) topping).isExtra() ? " (extra)" : "";
                        }
                        sb.append("   - ").append(topping.getName()).append(extraTopping).append("\n");
                    }
                }
                if (item instanceof Chips) {
                    sb.append(" Chips \n");
                }
                if (item instanceof Drink drink) {
                    sb.append("    Drink size: ").append(drink.getSize()).append("\n");
                }
                double price = item.getPrice();
                total += price;
            }
            System.out.println("Thank you for your order!");
            sb.append(String.format("TOTAL: $%.2f\n", total));
            sb.append("====================================\n");
            return sb.toString();
        }
}
