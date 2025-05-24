package org.example;

import java.util.Scanner;

public class MeatTopping extends Topping{
    private boolean isExtra;

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public MeatTopping(String name, boolean isExtra) {
        super(name);
        this.isExtra = isExtra;


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
                base = 0;
                System.out.println("No meat");
        }
        if(isExtra){
            switch (size){
                case 4:
                    base += 0.50;
                    break;
                case 8:
                    base += 1.00;
                    break;
                case 12:
                    base += 1.50;
                    break;
                default:
                    System.out.println("No meat.");
            }
        }
        return base;
    }
}
