package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

        if (this.dealership == null) {
            System.out.println("Error, look in the UI inIt method.");
        } else {
            System.out.println("Dealership loaded successfully: " + dealership);
        }
    }

    public void display() {
        init();

        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.println("Enter you choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processCreateContractRequest();
                    break;
                case 0:
                    // fileManager.saveDealership(dealership);
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
    }


    private void displayMenu() {
        System.out.println("\n === Main Menu === \n");
        System.out.println("1) Get vehicles by price.\n");
        System.out.println("2) Get vehicles by make and model.\n");
        System.out.println("3) Get vehicles by year.\n");
        System.out.println("4) Get vehicles by color.\n");
        System.out.println("5) Get vehicles by mileage.\n");
        System.out.println("6) Get vehicles by type.\n");
        System.out.println("7) Get ALL vehicles.\n");
        System.out.println("8) Add a vehicles\n");
        System.out.println("9) Remove a vehicle\n");
        System.out.println("10) Sale or Lease vehicle\n");
        System.out.println("0) Exit\n");
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter the max price: ");
        double maxPrice = scanner.nextDouble();
        //Get the filtered vehicles from the dealership
        List<Vehicle> filteredVehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        //Display this filtered vehicles
        displayVehicles(filteredVehicles);
    }

    public void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the make: ");
        String makeName = scanner.nextLine().trim();
        System.out.println("Enter the model: ");
        String modelName = scanner.nextLine().trim();
        //Get the filtered vehicles
        List<Vehicle> filteredMakeModel = dealership.getVehiclesByMakeModel(makeName, modelName);
        //Display filtered vehicles
        displayVehicles(filteredMakeModel);
    }

    public void processGetYearRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the minimum year: ");
        int minYear = scanner.nextInt();
        System.out.println("Enter the max year: ");
        int maxYear = scanner.nextInt();
        //Get the filtered vehicles from the dealership
        List<Vehicle> filteredVehicles = dealership.getVehiclesByYear(minYear, maxYear);
        //Display this filtered vehicles
        displayVehicles(filteredVehicles);
    }

    public void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the color: ");
        String color = scanner.nextLine().trim();
        //Get the filtered vehicles
        List<Vehicle> filteredColor = dealership.getVehiclesByColor(color);
        //Display filtered vehicles
        displayVehicles(filteredColor);
    }

    public void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.println("Enter the max mileage: ");
        int maxMileage = scanner.nextInt();
        //Get the filtered vehicles from the dealership
        List<Vehicle> filteredVehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        //Display this filtered vehicles
        displayVehicles(filteredVehicles);
    }

    public void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of vehicle: ");
        String type = scanner.nextLine().trim();
        List<Vehicle> filteredType = dealership.getVehiclesByType(type);
        displayVehicles(filteredType);
    }

    //process method to show all vehicles:
    public void processAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getInventory();
        displayVehicles(allVehicles);
    }

    public void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Vehicle VIN: ");
        int vin = scanner.nextInt();
        System.out.println("Enter the year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter make of car: ");
        String make = scanner.nextLine();
        System.out.println("Enter model of car: ");
        String model = scanner.nextLine();
        System.out.println("Enter type of car: ");
        String type = scanner.nextLine();
        System.out.println("Enter the color: ");
        String color = scanner.nextLine();
        System.out.println("Enter mileage: ");
        int odometer = scanner.nextInt();
        System.out.println("Enter the price");
        double price = scanner.nextDouble();
        scanner.nextLine();
        //create the vehicle object
        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        //add vehicle to the dealership
        dealership.addVehicle(newVehicle); //ensure dealership is initialized
        DealershipFileManager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Vehicle VIN you want to remove: ");
        int vinToRemove = scanner.nextInt();

        List<Vehicle> currentInventory = dealership.getInventory();
        boolean removed = currentInventory.removeIf(vehicle -> vehicle.getVin() == vinToRemove);
        if (removed) {
            System.out.println("Vehicle removed from dealership.");
            DealershipFileManager.overWriteInventoryFile(dealership);
        } else {
            System.out.println("Vehicle with VIN: " + vinToRemove + " not found.");
        }
    }

    public void processCreateContractRequest() {

        ContractFileManager contractFileManager = new ContractFileManager();
        scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        System.out.print("Enter VIN of the vehicle: ");
        int vin = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        Vehicle vehicle = dealership.getVehicleByVin(vin);
        if (vehicle == null) {
            System.out.println("Vehicle not found");
            return;
        }
        System.out.println("Is this a SALE or LEASE? (1.SALE / 2.LEASE)");
        int userChoice = scanner.nextInt();
        String date = String.valueOf(LocalDate.now());

        Contract contract;
        if (userChoice == 1) { //Sale
            System.out.println("Is the vehicle financed? (1.yes/2.no): ");
            int financedInput = scanner.nextInt();
            scanner.nextLine();
            boolean isFinanced = financedInput ==1;

            contract = new SalesContract(date, name, email, vin, isFinanced, dealership);
            System.out.println("Vehicle sold: " + contract);

        } else if (userChoice == 2) { //Lease
            double expectedEndingValue = vehicle.getPrice() * 0.5;
            double leaseFee = vehicle.getPrice() * 0.07;
            contract = new LeaseContract(date, name, email, vin, expectedEndingValue,leaseFee, dealership);
            System.out.println("Vehicle sold: " + contract);

        } else {
            System.out.println("Invalid choice");
            return;
        }
        contractFileManager.saveContract(contract, dealership);
        dealership.removeVehicle(vin);
        DealershipFileManager.overWriteInventoryFile(dealership);
        System.out.println("Contract saved and vehicle removed from inventory.");

    }
}
