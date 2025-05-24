package org.example;

public abstract class Topping extends PricedItem{

    public Topping(String name){
        super(name);
    }

    @Override
    public double getPrice(){
        double price = 0;
        return price;
    }
}
