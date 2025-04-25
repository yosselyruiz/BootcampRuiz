package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    public static List<Product> readfile(){
       try{
           FileReader fileReader = new FileReader("src/main/resources/products.csv");
           BufferedReader bufferedReader = new BufferedReader(fileReader);
            //Skip the 1st line.
           bufferedReader.readLine();

            String input;
            //As we go along, we will ADD to this list.
            List<Product> productList = new ArrayList<>();
            //Read the line one by one until the END of the file/
            while((input = bufferedReader.readLine()) != null){
                String[] row = input.split("\\|");

                //Convert data as needed
                //Index 0=SKU,1=ProductName,2=Price, 3=Department
                String sku = row[0];
                String productName = row[1];
                double price = Double.parseDouble(row[2]);
                String department = row[3];
                //bundle the above data together
                Product product = new Product(sku, productName,price,department);
                //Adding to the list
                productList.add(product);
            }
            bufferedReader.close();
            return productList;
       }
        catch (IOException ex){
            System.out.println("Failed to load csv file");
            return new ArrayList<>();
        }
    }

}
