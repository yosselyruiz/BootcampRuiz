package org.example;

public class SalesContract extends Contract {
    private boolean finance;
    private double tax;
    private double recordingFee;
    private double processingFee;
    private Dealership dealership;


    public SalesContract(String dateOfContract, String customerName, String email, int vehicleSoldByVin, boolean finance, Dealership dealership) {
        super(dateOfContract, customerName, email, vehicleSoldByVin, dealership);
        this.finance = finance;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }
    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }


    @Override
    public double getTotalPrice() {
        Vehicle vehicle = getVehicle(dealership);
        if (vehicle == null) {
            return 0;
        }
        double price = vehicle.getPrice();
        this.tax = price * 0.005;
        this.recordingFee = 100;
        this.processingFee = (price < 10000) ? 295 : 495;
        return price + tax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) {
            return 0;
        }
        //get the vehicle being sold:
        Vehicle soldVehicle = getVehicle(dealership);
        //Does it exist?
        if (soldVehicle == null) {
            System.out.println("Vehicle not found.");
            return 0;
        }

        //Get price of vehicle:
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
        double monthlyInterest = rate / 12;
        double monthlyPayment = (price * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -months));
        return monthlyPayment;
    }
}
