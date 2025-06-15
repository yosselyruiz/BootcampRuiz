package org.example;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private DatabaseManager databaseManager;

    public void init(String connectionString, String username, String password) {
        this.databaseManager = new DatabaseManager(connectionString, username, password);
    }

    public void display(String connectionString, String username, String password) {
        init(connectionString,username,password);
        Scanner scanner = new Scanner(System.in);
        boolean inDisplay = true;

        while (inDisplay) {
            System.out.println("=== Dealership Menu ===\n");
            System.out.println("1)Search by Price");
            System.out.println("2)Search Make/Model");
            System.out.println("3)Search Year");
            System.out.println("4)Search Color");
            System.out.println("5)Search by Mileage");
            System.out.println("6)Search by Vehicle Type");
            System.out.println("7)Search All Vehicles");
            System.out.println("8)Add New Vehicle");
            System.out.println("9)Remove Vehicle");
            System.out.println("10)Create Sale Contact");
            System.out.println("11)Create Lease Contract");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    processGetByPrice(scanner);
                    break;
                case 2:
                   processGetByMake(scanner);
                    break;
                case 3:
                    processGetByYear(scanner);
                    break;
                case 4:
                   processGetByColor(scanner);
                    break;
                case 5:
                   processGetByMileage(scanner);
                    break;
                case 6:
                   processGetByVehicleType(scanner);
                    break;
                case 7:
                    processGetAllVehicles();
                    break;
                case 8:
                    processAddVehicle(scanner);
                    break;
                case 9:
                    processRemoveVehicle(scanner);
                    break;
                case 10:
                    processSalesContract(scanner);
                    break;
                case 11:
                    processLeaseContract(scanner);
                    break;
                case 0:
                    inDisplay = false;
                    break;
                default:
                    System.out.println("invalid choice.Try again.");
            }
        }
    }

    public void processGetByPrice(Scanner scanner) {
        System.out.println("\n Search Price");
        System.out.println("What is the minimum price you're looking to pay?");
        double minPrice = scanner.nextDouble();
        System.out.println("What is the maximum price you're looking to pay?");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();
        List<Vehicle> results = databaseManager.getByPriceRange(minPrice, maxPrice);
       if(results.isEmpty()){
           System.out.println("No vehicles found in this price range.");
       } else {
           for (Vehicle v : results){
               System.out.println(v);
           }
       }
    }
    private void processGetByMake(Scanner scanner) {
        scanner.nextLine();
        System.out.println("=== Search by Make ===");
        System.out.println("Enter Vehicle Make: ");
        String vehicleMake = scanner.nextLine();
        List<Vehicle> results = databaseManager.getByMake(vehicleMake);
        if(results.isEmpty()){
            System.out.println("No vehicles found with this make.");
        } else {
            for (Vehicle v : results) {
                System.out.println(v);
            }
        }
    }
    private void processGetByYear(Scanner scanner) {
        System.out.println("\nSearch by Year");
        System.out.println("Enter Year");
        int year = scanner.nextInt();
        scanner.nextLine();
        List<Vehicle> results = databaseManager.getByYear(year);
        if(results.isEmpty()){
            System.out.println("No vehicles found with this year.");
        } else {
            for (Vehicle v : results) {
                System.out.println(v);
            }
        }
    }
    private void processGetByColor(Scanner scanner) {
        System.out.println("\nSearch by Color");
        scanner.nextLine();
        System.out.println("Enter Color: ");
        String color = scanner.nextLine();
        List<Vehicle> results = databaseManager.getByColor(color);
        if(results.isEmpty()){
            System.out.println("No vehicles found with this make.");
        } else {
            for (Vehicle v : results) {
                System.out.println(v);
            }
        }
    }
    private void processGetByMileage(Scanner scanner) {
        System.out.println("\nSearch by Mileage");
        System.out.println("What is the minimum mileage you would like ?");
        int minOdometer = scanner.nextInt();
        System.out.println("What is the maximum mileage you would like?");
        int maxOdometer = scanner.nextInt();
        scanner.nextLine();
        List<Vehicle> results = databaseManager.getByOdometer(minOdometer, maxOdometer);
        if(results.isEmpty()){
            System.out.println("No vehicles found in this price range.");
        } else {
            for (Vehicle v : results){
                System.out.println(v);
            }
        }
    }
    private void processGetByVehicleType(Scanner scanner) {
        System.out.println("Search by Vehicle Type");
        scanner.nextLine();
        System.out.println("Enter Vehicle Type");
        String vehicleType = scanner.nextLine();
        List<Vehicle> results = databaseManager.getByVehicleType(vehicleType);
        if(results.isEmpty()){
            System.out.println("No vehicles found in this price range.");
        } else {
            for (Vehicle v : results){
                System.out.println(v);
            }
        }
    }
    private void processGetAllVehicles() {
        System.out.println("Show all Vehicles");
        List<Vehicle> results = databaseManager.getAllVehicles();
        if(results.isEmpty()){
            System.out.println("Error loading all vehicles.");
        } else {
            for (Vehicle v : results) {
                System.out.println(v);
            }
        }
    }
    private void processAddVehicle(Scanner scanner) {
        System.out.println("Add New Vehicle");
        System.out.println("Enter VIN");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Add year of Vehicle");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Add Vehicle Make");
        String make = scanner.nextLine();
        System.out.println("Add Vehicle Model");
        String model = scanner.nextLine();
        System.out.println("Add Vehicle Type");
        String vehicleType = scanner.nextLine();
        System.out.println("Add Color of Vehicle");
        String color = scanner.nextLine();
        System.out.println("Add Vehicle Mileage");
        int odometer = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Add Price");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Add Dealership ID");
        int dealershipId = scanner.nextInt();
        scanner.nextLine();

        Vehicle newVehicle = new Vehicle();
        newVehicle.setVin(vin);
        newVehicle.setYear(year);
        newVehicle.setMake(make);
        newVehicle.setModel(model);
        newVehicle.setVehicleType(vehicleType);
        newVehicle.setColor(color);
        newVehicle.setOdometer(odometer);
        newVehicle.setPrice(price);
        newVehicle.setDealershipId(dealershipId);
        databaseManager.addVehicle(newVehicle);
        System.out.println("New vehicle added !");
    }
    private void processRemoveVehicle(Scanner scanner) {
        System.out.println("Remove vehicle");
        System.out.println("Enter VIN");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle toRemove = null;
        for (Vehicle vehicle : databaseManager.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                toRemove = vehicle;
                break;
            }
        }
        if(toRemove != null){
            databaseManager.removeVehicle(vin);
            System.out.println("Vehicle removed: " + toRemove);
        }
        else{
            System.out.println("No vehicle found with that vin");
        }
    }
    private void processSalesContract(Scanner scanner) {
        System.out.println("=== Create Sales Contract ===");
        System.out.print("Enter VIN of vehicle being sold: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        Vehicle vehicle = null;
        for (Vehicle v : databaseManager.getAllVehicles()) {
            if (v.getVin() == vin) {
                vehicle = v;
                break;
            }
        }
        if (vehicle == null) {
            System.out.println("Vehicle not found with VIN: " + vin);
            return;
        }
        System.out.print("Enter buyer's full name: ");
        String name = scanner.nextLine();

        // You can auto-generate or simulate a unique contract ID here (simple version)
        int id = (int) (Math.random() * 100000); // Simple random ID
        LocalDate date = LocalDate.now();

        SalesContractDao contract = new SalesContractDao();
        contract.setDate(date);
        contract.setName(name);
        contract.setId(id);
        contract.setVin(vin);

        databaseManager.salesContract(contract);
        databaseManager.removeVehicle(vin);
        System.out.println("Sales contract created and vehicle removed from inventory.");
    }
    private void processLeaseContract(Scanner scanner) {
        System.out.println("=== Create Lease Contract ===");
        System.out.print("Enter VIN of vehicle being leased: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicle = null;
        for (Vehicle v : databaseManager.getAllVehicles()) {
            if (v.getVin() == vin) {
                vehicle = v;
                break;
            }
        }
        if (vehicle == null) {
            System.out.println("Vehicle not found with VIN: " + vin);
            return;
        }
        System.out.print("Enter lessee's full name: ");
        String name = scanner.nextLine();
        int id = (int) (Math.random() * 100000);
        LocalDate date = LocalDate.now();

        LeaseContractDao contract = new LeaseContractDao();
        contract.setDate(date);
        contract.setName(name);
        contract.setId(id);
        contract.setVin(vin);

        databaseManager.leaseContract(contract);
        databaseManager.removeVehicle(vin);
        System.out.println("Lease contract created and vehicle removed from inventory.");
    }
}
