package org.example;

public abstract class PricedItem {
    private String name;

    public PricedItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     public double getPrice(){

         return 0;
     }
}
