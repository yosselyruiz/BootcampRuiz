package org.example;
import javax.swing.*;
import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class DealershipFileManager {

    public Dealership getDealership() {
        try {
            FileReader file = new FileReader("src/main/resources/inventory.csv");
            BufferedReader br = new BufferedReader(file);

            //Read 1st line of dealership info:
            String [] dealershipInfo = br.readLine().split("\\|");
            String name = dealershipInfo[0];
            String address = dealershipInfo[1];
            String phone = dealershipInfo[2];

            Dealership dealership = new Dealership(name, address, phone);

            String input;
            //Read the line one by one until the End of the file:
            while((input = br.readLine()) != null){
                String [] row = input.split("\\|");
                //convert the date:
                int vin = Integer.parseInt(row[0]);
                int year = Integer.parseInt(row[1]);
                String make = row[2];
                String model = row[3];
                String type = row[4];
                String color = row[5];
                int odometer = Integer.parseInt(row [6]);
                double price = Double.parseDouble(row[7]);

                //bundle the data above
                Vehicle vehicle = new Vehicle(vin,year,make,model,type,color,odometer,price);
                dealership.addVehicle(vehicle); // add to dealership inventory
            }
            br.close();
            return dealership;
        }
        catch (Exception EX) {
            System.out.println("Failed to load inventory file: " + EX.getMessage());
            EX.printStackTrace();
            return null;
        }
    }

    public static void saveDealership(Dealership dealership){
        String filePath = "src/main/resources/inventory.csv";
        File file = new File(filePath);

        try{
          File folder = file.getParentFile();
          if(!folder.exists()){
              folder.mkdirs();
          }

          FileWriter writer = new FileWriter(file, true);
          writer.write("Best Cars|123 Main St|555-1234");
          for(Vehicle v: dealership.getInventory()){
              writer.write(v.toString() + "\n");
          }
          writer.close();
            System.out.println("Vehicle was added to file.");
        }
        catch (IOException exception){
            System.out.println("Error occurred while writting transactions to the file.");
        }
    }
    public static void overWriteInventoryFile(Dealership dealership){
        String filePath = "src/main/resources/inventory.csv";
        File file = new File(filePath);

        try(FileWriter writer = new FileWriter(file)){
            //write dealership info:
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhoneNumber() + "\n");
            //write all vehicles
            for(Vehicle vehicle : dealership.getInventory()){
                writer.write(vehicle.toString() + "\n");
            }
            System.out.println("Inventory file overwritten successfully.");
        }
        catch (IOException ex){
            System.out.println("Error occurred while overwriting inventory file.");
        }
    }
}
