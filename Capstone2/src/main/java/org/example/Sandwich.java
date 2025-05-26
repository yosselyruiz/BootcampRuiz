package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends PricedItem{
    private String breadType;
    private boolean isToasted;
    private int size;
    private List<Topping> toppingList; //List of toppings in the order

    public Sandwich(String name, String breadType, boolean isToasted, int size) {
        super(name);
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.size = size;
        this.toppingList = new ArrayList<>(); //to initialize the list
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void addTopping(Topping topping){
        toppingList.add(topping);
    }

    @Override
    public double getPrice(){
        double base;
        switch (size){
            case 4:
                base = 5.50;
                break;
            case 8:
                base = 7.00;
                break;
            case 12:
                base = 8.50;
                break;
            default:
                throw new IllegalArgumentException("Please chose a valid size(4,8, or 12 in). " +
                        "Cannot remove bread.");
        }
        return base;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sandwich on ").append(breadType);
        sb.append(", ").append(size).append("\"");
        sb.append(", ").append(isToasted ? "Toasted" : "Not Toasted");
        sb.append("\n Toppings:");

        for(Topping topping : toppingList){
            sb.append("\n    - ").append(topping.getName());
            if(topping instanceof MeatTopping && ((MeatTopping) topping).isExtra()){
                sb.append(" (extra");
            }
        }
        return sb.toString();
    }
}
