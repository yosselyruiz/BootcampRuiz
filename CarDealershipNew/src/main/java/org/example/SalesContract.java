package org.example;

public class SalesContract extends Contract {
    private boolean finance;
    private Dealership dealership;

    public SalesContract(String dateOfContract, String customerName, String email, int vehicleSoldByVin, boolean finance) {
        super(dateOfContract, customerName, email, vehicleSoldByVin);
        this.finance = finance;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
        Vehicle vehicle = getVehicle(dealership);
        if (vehicle == null) {
            return 0;
        }
        double price = vehicle.getPrice();
        double tax = price * 0.005;
        double recordingFee = 100;
        double processingFee = (price < 10000) ? 295 : 495;
        return price + tax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) {
            return 0;
        }
        Vehicle soldVehicle = getVehicle(dealership);
        if (soldVehicle == null) {
            System.out.println("Vehicle not found.");
            return 0;
        }
        double price = soldVehicle.getPrice();
        double rate;
        int months;

        if (price >= 10000) {
            rate = 0.0425;
            months = 48;
        } else {
            rate = 0.0525;
            months = 24;
        }
        double totalPrice = getTotalPrice();
        double monthlyPayment = (totalPrice * (1 * rate)) / months;
        return monthlyPayment;
    }
}
