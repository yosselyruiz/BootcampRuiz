package org.example;


public class Main {
    public static void main(String[] args) {
        String username = "root2";
        String password = "2024MotherJ*";
        String connectionString = "jdbc:mysql://localhost:3306/dealership";

        UserInterface ui = new UserInterface();
        ui.display(connectionString, username, password);
    }
}