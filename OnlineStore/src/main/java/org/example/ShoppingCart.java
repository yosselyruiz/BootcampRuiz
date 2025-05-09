package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    //call the list library, and put the class Product and name the variable "products."
    //this will create a NEW list ready to add items. this is a constructor
    private List<Product> products = new ArrayList<>();

    public void displayItems(){
        for(Product product : products){
//            Product currentProduct = product.
            System.out.println(product.getProductName()+" SKU: "+product.getSku()+" $"+product.getPrice()+"\n");
        }
    }
    //Todo: add product to cart method
    public void addProductToCart(Product product) {
        products.add(product);
        System.out.println(product.getProductName()+" was added to your cart.\n");
    }
    //Todo: remove product from cart method
    //You will need the SKU of the product you want to remove.
    //Loop through the list of products
    //Check to see if the SKU matches
    //Get that product, then use the

    public boolean removeProductBySku(String sku) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getSku().equalsIgnoreCase(sku)) {
                products.remove(i);
                System.out.println("Removed item " + product.getProductName()+" from cart.");
                return true;
            }
        }
        return false;
    }
    //Todo: get cart total method
    public double getCartTotal () {
        double total = 0.0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}