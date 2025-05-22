package org.example;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    //add a method to save the contract by APPENDING it to your contracts file
    private static final String FILE_PATH = "src/main/resources/contracts.csv";

    public static void saveContract(Contract contract, Dealership dealership){
        try(FileWriter writer = new FileWriter(FILE_PATH,true)){
            if(contract instanceof SalesContract){
                SalesContract sale = (SalesContract) contract; //downcasting
                Vehicle vehicle = sale.getVehicle();
                writer.write(String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%d|%.2f\n",
                        sale.getDateOfContract(),
                        sale.getCustomerName(),
                        sale.getEmail(),
                        sale.getVehicleSoldByVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice(),
                        sale.getTax(),
                        sale.getProcessingFee(),
                        sale.getRecordingFee(),
                        sale.getTotalPrice(),
                        sale.isFinance(),
                        sale.getMonthlyPayment()
                        ));

            }
            else if (contract instanceof LeaseContract){
            LeaseContract lease = (LeaseContract) contract;
            Vehicle vehicle = lease.getVehicle();
            writer.write(String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f\n",
                    lease.getDateOfContract(),
                    lease.getCustomerName(),
                    lease.getEmail(),
                    lease.getVehicleSoldByVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice(),
                    lease.getExpectedEndingValue(),
                    lease.getLeaseFee(),
                    lease.getTotalPrice(),
                    lease.getMonthlyPayment()
                    ));
            }
        } catch (IOException ex){
            System.out.println("Error writing contract: " + ex.getMessage());
        }
    }
}
