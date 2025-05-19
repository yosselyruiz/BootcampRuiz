package org.example;

public class Vehicle {

        private int vin;
        private int year;
        private String make;
        private String model;
        private String type;
        private String color;
        private int odometer;
        private double price;

        public Vehicle (int vin, int year, String make, String model, String type, String color, int odometer, double price) {
            this.vin = vin;
            this.year = year;
            this.make = make;
            this.model = model;
            this.type = type;
            this.color = color;
            this.odometer = odometer;
            this.price = price;
        }

        public int getVin() {
            return vin;
        }

        public void setVin(int vin) {
            this.vin = vin;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getVehicleType() {
            return type;
        }

        public void setVehicleType(String vehicleType) {
            this.type = vehicleType;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getOdometer() {
            return odometer;
        }

        public void setOdometer(int odometer) {
            this.odometer = odometer;
        }

        public double getPrice() {

            return this.price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return vin + "|" + year + "|" + make + "|" + model + "|"
                    + type + "|" + color + "|" + odometer + "|" + price;
        }
    }
