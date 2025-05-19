package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Vehicle> inventory; //A list of vehicles in the dealership

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>(); //to initialize the list
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //Start the methods to search vehicle:

    public List<Vehicle> getVehiclesByPrice (double minPrice, double maxPrice){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getPrice() >= minPrice && v.getPrice() <= maxPrice){
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMakeModel (String make, String model){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory){
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)){
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByYear (int minYear, int maxYear){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getYear() >= minYear && v.getYear() <= maxYear){
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByColor (String color){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getColor().equalsIgnoreCase(color)){
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMileage (int minMileage, int maxMileage){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getOdometer() >= minMileage && v.getOdometer() <= maxMileage){
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByType(String type){
        List<Vehicle> result = new ArrayList<>();
        for(Vehicle v : inventory){
            if(v.getVehicleType().equalsIgnoreCase(type)){
                result.add(v);
            }
        }
        return result;
    }

//    public Vehicle getVehichleByVin (String vin){
//
//    }

    public void addVehicle (Vehicle vehicle) {
      inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        this.inventory.remove(vehicle);
    }

    public List<Vehicle> getInventory(){
        return inventory;

    }
}
