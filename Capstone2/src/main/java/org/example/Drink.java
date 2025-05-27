package org.example;

public class Drink extends PricedItem{
    private int size;


    public Drink(String name, int size) {
        super(name);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public double getPrice(){
        double base;
        switch (size){
            case 1:
                base = 2.00;
                break;
            case 2:
                base = 2.50;
                break;
            case 3:
                base = 3.00;
                break;
            default:
                base = 0.00;
                System.out.println("No drink.");
        }

        return base;
    }

    @Override
    public String toString(){
        return getName();
    }
}
