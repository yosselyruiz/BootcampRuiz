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
}
