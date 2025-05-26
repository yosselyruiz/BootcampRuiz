package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheeseTopping extends Topping{
    private boolean isExtra;
    private int size;


    public CheeseTopping(String name, boolean isExtra, int size) {
        super(name);
        this.isExtra = isExtra;
        this.size = size;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }


    @Override
    public double getPrice(){
        double base;
        switch (size){
            case 4:
                base = 1.00;
                break;
            case 8:
                base = 2.00;
                break;
            case 12:
                base = 3.00;
                break;
            default :
                base = 0.00;
                System.out.println("No cheese.");
        }
        if(isExtra){
            switch (size) {
                case 4:
                    base += 0.30;
                    break;
                case 8:
                    base += 0.60;
                    break;
                case 12:
                    base += 0.90;
                    break;
                default :
                    System.out.println("No cheese");
            }
        }
        return base;
    }
}
