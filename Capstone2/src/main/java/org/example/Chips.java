package org.example;

import java.util.Scanner;

public class Chips extends PricedItem{
    private boolean wantChips;

    public Chips(String name, boolean wantChips) {
        super(name);
        this.wantChips = wantChips;
    }

    public boolean isWantChips() {
        return wantChips;
    }

    public void setWantChips(boolean wantChips) {
        this.wantChips = wantChips;
    }
    @Override
    public double getPrice(){
        return 1.50;
    }
    //this is for my UI:
    //Scanner scanner = new Scanner(System.in);
    //System.out.print("Would you like to add chips? (yes/no): ");
    //String input = scanner.nextLine();
    //
    //if (input.equalsIgnoreCase("yes")) {
    //    Chips chips = new Chips("Chips");
    //    order.addItem(chips);
    //    System.out.println("Chips added.");
    //}
}
