package org.example;

public class Drink extends PricedItem{
    private String size;

    public Drink(String name, String size) {
        super(name);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    @Override
    public double getPrice(){

    }
}
