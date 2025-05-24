package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    @Override
    public double getPrice(){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        double base = 0;
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
                System.out.println("Must chose a type of bread.");
        }
        return base;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadType='" + breadType + '\'' +
                ", isToasted=" + isToasted +
                ", toppingList=" + toppingList +
                '}';
    }
}
