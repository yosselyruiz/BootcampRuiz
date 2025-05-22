package org.example;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leaseFee;


    public LeaseContract(String dateOfContract, String customerName, String email, int vehicleSoldByVin, double expectedEndingValue, double leaseFee, Dealership dealership) {
        super(dateOfContract, customerName, email, vehicleSoldByVin, dealership);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }
    @Override
    public double getTotalPrice(){
        Vehicle vehicle = getVehicle();
        if(vehicle == null){
            return 0;
        }
        double expectedEndingValue = vehicle.getPrice() * 0.5;
        double leaseFee = vehicle.getPrice() * 0.07;
        return expectedEndingValue + leaseFee;
    }
    @Override
    public double getMonthlyPayment() {
        Vehicle vehicle = getVehicle();
        double price = vehicle.getPrice();
        double interestRate = 0.04;
        int months = 36;
     //Formula for monthly payment:
        double monthlyInterest = interestRate / 12;
        double monthlyPayment = (price * monthlyInterest)/(1 - Math.pow(1 + monthlyInterest, -months));
        return monthlyPayment;
    }
}
