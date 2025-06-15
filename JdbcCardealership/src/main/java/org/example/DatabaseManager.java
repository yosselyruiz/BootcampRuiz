package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class DatabaseManager {

        private final String connectionString;
        private final String username;
        private final String password;

        public DatabaseManager(String connectionString, String username, String password) {
            this.connectionString = connectionString;
            this.username = username;
            this.password = password;
        }

        public Dealership getDealershipById(int dealershipId) {
            String query = "SELECT * FROM dealerships WHERE Dealership_ID = ?";
            Dealership dealership = null;

            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)){
                 stmt.setInt(1, dealershipId);

                 try(ResultSet rs = stmt.executeQuery()) {
                 if (rs.next()) {
                    Dealership newDealership = new Dealership();
                    newDealership.setDealership_Id(rs.getInt("Dealership_ID"));
                    newDealership.setName(rs.getString("Name"));
                    newDealership.setAddress(rs.getString("Address"));
                    newDealership.setPhone(rs.getString("Phone"));
                }
            }
        }
             catch (SQLException ex) {
                ex.printStackTrace();
            }
            return dealership;
        }
        //helper method for getAllDealerships
        public List<Vehicle> getAllVehicles() {
            List<Vehicle> list = new ArrayList<>();
            String query = "SELECT * FROM vehicles";
            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("VIN"));
                    newVehicle.setYear(rs.getInt("Year"));
                    newVehicle.setMake(rs.getString("Make"));
                    newVehicle.setModel(rs.getString("Model"));
                    newVehicle.setVehicleType(rs.getString("Vehicle_Type"));
                    newVehicle.setColor(rs.getString("Color"));
                    newVehicle.setOdometer(rs.getInt("Odometer"));
                    newVehicle.setPrice(rs.getDouble("Price"));
                    newVehicle.setDealershipId(rs.getInt("Dealership_ID"));
                    list.add(newVehicle);
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            return list;
        }
        //Search by Vin:
        public List<Vehicle> getByVin(int vin) {
            List<Vehicle> list = new ArrayList<>();
            String query = "SELECT * FROM vehicles WHERE vin = ?";

            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, vin);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                        Vehicle newVehicle = new Vehicle();
                        newVehicle.setVin(rs.getInt("VIN"));
                        newVehicle.setYear(rs.getInt("Year"));
                        newVehicle.setMake(rs.getString("Make"));
                        newVehicle.setModel(rs.getString("Model"));
                        newVehicle.setVehicleType(rs.getString("Vehicle_Type"));
                        newVehicle.setColor(rs.getString("Color"));
                        newVehicle.setOdometer(rs.getInt("Odometer"));
                        newVehicle.setPrice(rs.getDouble("Price"));
                        list.add(newVehicle);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return list;
        }
        //Search by Make:
        public List<Vehicle> getByMake (String make) {
            List<Vehicle> list = new ArrayList<>();
            String query = "SELECT * FROM vehicles WHERE make = ?";

            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, make);
                ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        Vehicle newVehicle = new Vehicle();
                        newVehicle.setVin(rs.getInt("VIN"));
                        newVehicle.setYear(rs.getInt("Year"));
                        newVehicle.setMake(rs.getString("Make"));
                        newVehicle.setModel(rs.getString("Model"));
                        newVehicle.setVehicleType(rs.getString("Vehicle_Type"));
                        newVehicle.setColor(rs.getString("Color"));
                        newVehicle.setOdometer(rs.getInt("Odometer"));
                        newVehicle.setPrice(rs.getDouble("Price"));
                        newVehicle.setDealershipId(rs.getInt("Dealership_ID"));
                        list.add(newVehicle);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return list;
        }
        //Search by vehicle type:
        public List<Vehicle> getByVehicleType(String vehicleType ) {
            List<Vehicle> list = new ArrayList<>();
            String query = "SELECT * FROM vehicles WHERE Vehicle_Type = ?";

            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, vehicleType);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                        Vehicle newVehicle = new Vehicle();
                        newVehicle.setVin(rs.getInt("VIN"));
                        newVehicle.setYear(rs.getInt("Year"));
                        newVehicle.setMake(rs.getString("Make"));
                        newVehicle.setModel(rs.getString("Model"));
                        newVehicle.setVehicleType(rs.getString("Vehicle_Type"));
                        newVehicle.setColor(rs.getString("Color"));
                        newVehicle.setOdometer(rs.getInt("Odometer"));
                        newVehicle.setPrice(rs.getDouble("Price"));

                        list.add(newVehicle);
                    }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return list;
        }
        //Search by Year:
        public List<Vehicle> getByYear(int year) {
            List<Vehicle> list = new ArrayList<>();
            String query = "SELECT * FROM vehicles WHERE year = ?";

            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, year);
                ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        Vehicle newVehicle = new Vehicle();
                        newVehicle.setVin(rs.getInt("VIN"));
                        newVehicle.setYear(rs.getInt("Year"));
                        newVehicle.setMake(rs.getString("Make"));
                        newVehicle.setModel(rs.getString("Model"));
                        newVehicle.setVehicleType(rs.getString("Vehicle_Type"));
                        newVehicle.setColor(rs.getString("Color"));
                        newVehicle.setOdometer(rs.getInt("Odometer"));
                        newVehicle.setPrice(rs.getDouble("Price"));
                        newVehicle.setDealershipId(rs.getInt("Dealership_ID"));
                        list.add(newVehicle);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return list;
        }
        //Search by color
        public List<Vehicle> getByColor(String color) {
            List<Vehicle> list = new ArrayList<>();
            String query = "SELECT * FROM vehicles WHERE color = ?";

            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, color);
                ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        Vehicle newVehicle = new Vehicle();
                        newVehicle.setVin(rs.getInt("VIN"));
                        newVehicle.setYear(rs.getInt("Year"));
                        newVehicle.setMake(rs.getString("Make"));
                        newVehicle.setModel(rs.getString("Model"));
                        newVehicle.setVehicleType(rs.getString("Vehicle_Type"));
                        newVehicle.setColor(rs.getString("Color"));
                        newVehicle.setOdometer(rs.getInt("Odometer"));
                        newVehicle.setPrice(rs.getDouble("Price"));
                        newVehicle.setDealershipId(rs.getInt("Dealership_ID"));
                        list.add(newVehicle);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return list;
        }
        //Search by mileage range
        public List<Vehicle> getByOdometer(int minOdometer, int maxOdometer) {
            List<Vehicle> list = new ArrayList<>();
            String query = "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?";
            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, minOdometer);
                stmt.setInt(2, maxOdometer);
                ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        Vehicle newVehicle = new Vehicle();
                        newVehicle.setVin(rs.getInt("VIN"));
                        newVehicle.setYear(rs.getInt("Year"));
                        newVehicle.setMake(rs.getString("Make"));
                        newVehicle.setModel(rs.getString("Model"));
                        newVehicle.setVehicleType(rs.getString("Vehicle_Type"));
                        newVehicle.setColor(rs.getString("Color"));
                        newVehicle.setOdometer(rs.getInt("Odometer"));
                        newVehicle.setPrice(rs.getDouble("Price"));
                        newVehicle.setDealershipId(rs.getInt("Dealership_ID"));

                        list.add(newVehicle);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return list;
        }
        //Search by price range
        public List<Vehicle> getByPriceRange(double minPrice, double maxPrice) {
            List<Vehicle> list = new ArrayList<>();
            String query = "SELECT * FROM vehicles WHERE Price BETWEEN ? AND ?";
            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setDouble(1, minPrice);
                stmt.setDouble(2, maxPrice);
                ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        Vehicle newVehicle = new Vehicle();
                        newVehicle.setVin(rs.getInt("VIN"));
                        newVehicle.setYear(rs.getInt("Year"));
                        newVehicle.setMake(rs.getString("Make"));
                        newVehicle.setModel(rs.getString("Model"));
                        newVehicle.setVehicleType(rs.getString("Vehicle_Type"));
                        newVehicle.setColor(rs.getString("Color"));
                        newVehicle.setOdometer(rs.getInt("Odometer"));
                        newVehicle.setPrice(rs.getDouble("Price"));
                        newVehicle.setDealershipId(rs.getInt("Dealership_ID"));
                        list.add(newVehicle);
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            return list;
        }
        //Delete
        public void removeVehicle(int vin) {
            String query = "DELETE FROM vehicles WHERE vin = ?";
            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setInt(1, vin);
                stmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //Add
        public void addVehicle(Vehicle vehicle) {
            String query = "INSERT INTO vehicles (VIN, Year, Make, Model, Vehicle_Type, Color, Odometer, Price, Dealership_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setInt(1, vehicle.getVin());
                stmt.setInt(2, vehicle.getYear());
                stmt.setString(3, vehicle.getMake());
                stmt.setString(4, vehicle.getModel());
                stmt.setString(5, vehicle.getVehicleType());
                stmt.setString(6, vehicle.getColor());
                stmt.setInt(7, vehicle.getOdometer());
                stmt.setDouble(8, vehicle.getPrice());
                stmt.setInt(9, vehicle.getDealershipId());
                stmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //Add to Sales contract:
        public void salesContract(SalesContractDao salesContract) {
            String query = "INSERT INTO sales_contracts (Date, Name, ID, VIN) VALUES (?, ?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(connectionString, username, password);
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setDate(1, java.sql.Date.valueOf(salesContract.getDate()));
                stmt.setString(2, salesContract.getName());
                stmt.setInt(3, salesContract.getId());
                stmt.setInt(4, salesContract.getVin());
                stmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    //Lease contract:
    public void leaseContract(LeaseContractDao leaseContract) {
        String query = "INSERT INTO lease_contracts (Date, Name, ID, VIN) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(connectionString, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDate(1, java.sql.Date.valueOf(leaseContract.getDate()));
            stmt.setString(2, leaseContract.getName());
            stmt.setInt(3, leaseContract.getId());
            stmt.setInt(4, leaseContract.getVin());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }









        //Update
        public void update(Dealership dealership){
            String query = "UPDATE dealerships SET Name = ?, Address = ?, WHERE Dealership_ID = ?";

            try(Connection conn = DriverManager.getConnection(connectionString,username,password);
                PreparedStatement stmt = conn.prepareStatement(query)){

                stmt.setString(1,dealership.getName());
                stmt.setString(2,dealership.getAddress());

                stmt.executeUpdate();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
