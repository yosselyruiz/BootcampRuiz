package org.example;

import java.util.Scanner;

public class CheeseTopping extends Topping{
    private boolean isExtra;

    public CheeseTopping(String name, boolean isExtra) {
        super(name);
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    @Override
    public double getPrice(){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
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
        };
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
