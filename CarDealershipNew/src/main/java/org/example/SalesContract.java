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
        this.dealership = dealership;
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
    public String toString() {
        return "SalesContract{" +
                "customerName='" + getCustomerName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", vin=" + getVehicleSoldByVin() +
                ", financed=" + finance +
                ", totalPrice=" + getTotalPrice() +
                ", monthlyPayment=" + getMonthlyPayment() +
                '}';
    }

    @Override
    public double getTotalPrice() {
        Vehicle vehicle = getVehicle();
        if (vehicle == null) {
            return 0;
        }
        double price = vehicle.getPrice();
        this.tax = price * 0.05;
        this.recordingFee = 100;
        this.processingFee = (price < 10000) ? 295 : 495;
        return (price + tax) + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) {
            return 0;
        }
        //get the vehicle being sold:
        Vehicle soldVehicle = getVehicle();
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
            rate = price * 0.0425;
            months = 48;
            return (price + rate) / months;
        } else {
            rate = price * 0.0525;
            months = 24;
            return (price + rate) / months;
        }
    }
}
