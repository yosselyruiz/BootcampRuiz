package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //try();
        //call the cvs loading
        List<Product> products = FileLoader.readfile();
        Scanner scanner = new Scanner(System.in);
        //Instantiate the ShoppingCart and Product class:
        ShoppingCart cart = new ShoppingCart();

        while(true){
            System.out.println("Main menu \n");
            //Thread.sleep(1000);
            System.out.println("1) Show all products.");
            System.out.println("2) Display cart");
            System.out.println("3) Remove products from cart");
            System.out.println("4) Exit \n");
            int userChoice = scanner.nextInt();


            switch (userChoice) {
                case 1:
                    displayProducts(scanner,cart);
                    break;
                case 2:
                    System.out.printf("Your cart total is: $%.2f.\n", cart.getCartTotal());
                   cart.displayItems();
                    break;
                case 3:
                    cart.displayItems();
                    removeProductWithSku(scanner,cart);
                    break;
                case 4:
                    System.exit(0);
                }
            }
        }

    public static void displayProducts(Scanner scanner, ShoppingCart shoppingCart) {
        System.out.println("Here is the list of products: \n");
        List<Product> products = FileLoader.readfile();
        //calls to loop through the Product array and displays all the products:
        for (Product product : products) {
            System.out.println(product.getProductName()+ " " + product.getSku()+ " $" + product.getPrice());
        }
        System.out.println("\nWhat would you like to do? \n");
        System.out.println("1) search product by SKU");
        System.out.println("2) add product to cart");
        System.out.println("3) go back to home page");
        int userChoice = scanner.nextInt();
        if (userChoice == 1) {
            System.out.println("Please enter the SKU of the item you want to search. ");
            String searchProduct = scanner.next();
            boolean found = false;
            for (Product product : products) {
                if (product.getSku().equalsIgnoreCase(searchProduct)) {
                    System.out.println(product.getProductName() + " $" + product.getPrice());
                    found = true;
                    break;
                } else {
                    System.out.println("No product found \n");
                    break;
                }
            }
        }
        if (userChoice == 2) {
            scanner.nextLine();
            System.out.println("Enter the SKU of the product you would like to add to your cart.");
            String userSku = scanner.nextLine();


            for (Product product : products) {
                if (product.getSku().equalsIgnoreCase(userSku)) {
                    shoppingCart.addProductToCart(product);
                    break;
                }
            }

        }
        if (userChoice == 3)
            System.exit(0);
    }
    public static void removeProductWithSku (Scanner scanner, ShoppingCart shoppingCart){
        scanner.nextLine();
        System.out.println("Remove product from cart. Please enter the SKU:");
        String userSku = scanner.nextLine();

        boolean removed = shoppingCart.removeProductBySku(userSku);

        if(removed){
            System.out.println("Thank you for your business!\n");
        } else {
            System.out.println("No product found in your cart with that sku.");
        }
    }

}