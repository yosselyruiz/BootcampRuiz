package org.example;

public abstract class Contract {
    //Cannot create a generic contract:
    private String dateOfContract;
    private String customerName;
    private String email;
    private int vehicleSoldByVin;
    private double price;
    private double monthlyPayment;

    public Contract(String dateOfContract, String customerName, String email, int vehicleSoldByVin) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.email = email;
        this.vehicleSoldByVin = vehicleSoldByVin;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVehicleSoldByVin() {
        return vehicleSoldByVin;
    }

    public void setVehicleSoldByVin(int vehicleSoldByVin) {
        this.vehicleSoldByVin = vehicleSoldByVin;
    }
    //This is so that the vehicle sold by vin can also display the price of it.
    public Vehicle getVehicle(Dealership dealership){
        for(Vehicle v : dealership.getInventory()){
            if(v.getVin() == this.vehicleSoldByVin){
                return v;
            }
        }
        return null;
    }
    public void setPrice (double price){
        this.price = price;
    }

    public double getTotalPrice(){
        return price;
    }
    public double getMonthlyPayment(){
        return monthlyPayment;
    }
}
