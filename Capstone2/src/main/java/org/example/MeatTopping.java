package org.example;


public class MeatTopping extends Topping{
    private boolean isExtra;
    private int size;

    public MeatTopping(String name, boolean isExtra, int size) {
        super(name);
        this.isExtra = isExtra;
        this.size = size;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public double getPrice(){
        double base = 0.0;
        switch (size) {
            case 4:
                base = 1.00;
                break;
            case 8:
                base = 2.00;
                break;
            case 12:
                base = 3.00;
                break;
            default:
                base = 0.00;
                System.out.println("No meat.");
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
