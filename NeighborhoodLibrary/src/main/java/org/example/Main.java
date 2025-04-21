package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //make the array for the 20 books
        Book[] inventory = new Book[20];

        //This is the list of books at the neighborhood library.
        inventory[0] = new Book(1, "A1234", "The Secret Garden", true, "Ana");
        inventory[1] = new Book(2, "B5678", "Journey to the Moon", true, "Robert");
        inventory[2] = new Book(3, "C1234", "Tales of the Ocean", true, "Hannah");
        inventory[3] = new Book(4, "D4321", "The Last Dragon", false, null);
        inventory[4] = new Book(5, "E8765", "Adventures in Time", true, "Liam");
        inventory[5] = new Book(6, "F2468", "The Forgotten Forest", false, null);
        inventory[6] = new Book(7, "G1357", "Mystery at Midnight", true, "Olivia");
        inventory[7] = new Book(8, "H9753", "Under the Starry Sky", false, null);
        inventory[8] = new Book(9, "I8642", "Robot and the Rainbow", true, "Mason");
        inventory[9] = new Book(10, "J7531", "The Pirate’s Gold", false, null);
        inventory[10] = new Book(11, "K6420", "Whispering Winds", true, "Chloe");
        inventory[11] = new Book(12, "L5319", "The Magic Paintbrush", false, null);
        inventory[12] = new Book(13, "M4208", "A Tale of Two Kittens", true, "Noah");
        inventory[13] = new Book(14, "N3197", "The Haunted Library", true, "Ella");
        inventory[14] = new Book(15, "O2086", "Snowfall in the Mountains", false, null);
        inventory[15] = new Book(16, "P1075", "The Girl Who Could Fly", false, null);
        inventory[16] = new Book(17, "Q9064", "Lightning in the Desert", true, "Sophia");
        inventory[17] = new Book(18, "R8053", "The Clockmaker’s Code", false, null);
        inventory[18] = new Book(19, "S7042", "Beneath the Willow Tree", true, "Lucas");
        inventory[19] = new Book(20, "T6031", "Lost in the Land of Dreams", false, null);

        //Make the main menu:
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("What would you like to do?");
            Thread.sleep(1000);
            System.out.println("1) Show available books");
            System.out.println("2) Show checked out books");
            System.out.println("3) Check in a book by ISBN");
            System.out.println("4) Check out book by ISBN");
            System.out.println("5) Search by title of book.");
            System.out.println("6) Exit.");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    showAvailableBooks(inventory);
                    //break to end loop
                    break;
                case 2:
                    showCheckedOutBooks(inventory, scanner);
                    break;
                case 3:
                    checkInBookByIsbn(inventory, scanner);
                    break;
                case 4:
                    checkOutBookByIsbn(inventory, scanner);
                    break;
                case 5:
                    seacrhByTitle(inventory, scanner);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    //This is the for statement for 1 of menu
    public static void showAvailableBooks(Book[] inventory) {
        for (int i = 0; i < inventory.length; i++) {
            //create a variable for currentBooks
            Book currentBook = inventory[i];
            if (currentBook != null && !currentBook.isCheckedOut) {
                System.out.println(currentBook.getTitle());
            }
        }
    }

    public static void showCheckedOutBooks(Book[] inventory, Scanner scanner) {
        //This is for statement showCheckedoutBook
        scanner.nextLine();
        String title = scanner.nextLine();
        //create a for loop to list ALl books that are checked out(true)
        for (int i = 0; i < inventory.length; i++) {
            Book showCheckedOutBook = inventory[i];
            if (showCheckedOutBook != null && showCheckedOutBook.isCheckedOut)
                System.out.println(showCheckedOutBook.toString());
        }
    }

    public static void checkInBookByIsbn(Book[] inventory, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Please enter the ISBN of the book to check in book.");
        String isbnInput = scanner.nextLine();
        for (int i = 0; i < inventory.length; i++) {
            Book book = inventory[i];
            // for (Book book : inventory) {
            if (book != null && book.getIsbn().equalsIgnoreCase(isbnInput)) {
                book.checkIn();
                break;
            }
        }
    }

    public static void checkOutBookByIsbn(Book[] inventory, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Please enter the ISBN of the book to check out book.");
        //save user input into this variable:
        String isbnInputForCheckOut = scanner.nextLine();
        //variable to track if the book is found. False because we have not found yet,
        //we are trying to find ir using for loop:
        boolean bookFound = false;
        for (int i = 0; i < inventory.length; i++) {
            Book book = inventory[i];
//            //Check if the ISBN inputted matches the inventory of books:
            if (book != null && book.getIsbn().equalsIgnoreCase(isbnInputForCheckOut)) {
                bookFound = true;
                //Books is already checked out
                if (book.isCheckedOut) {
                    System.out.println("Book is already checked out. Sorry!");
                } else {
                    //Book is available, check out:
                    System.out.println("Enter your name to check out the book.");
                    String borrowerName = scanner.nextLine();
                    book.checkOut(borrowerName);
                }
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Sorry, this ISBN was not found in the system.");
            {
            }
        }
    }

    public static void seacrhByTitle(Book[] inventory, Scanner scanner) {
        System.out.println("Please provide the title of the book you would like to search up.");
        scanner.nextLine();
        String titleOfBookToSearch = scanner.nextLine().toLowerCase();
        boolean bookFound = false;
        for (int i = 0; i < inventory.length; i++) {
            Book currentBook = inventory[i];
            if (currentBook != null && currentBook.getTitle().toLowerCase().contains(titleOfBookToSearch)) {
                System.out.println(currentBook.toString());
                bookFound = true;
                if (currentBook.isCheckedOut()) {
                    System.out.println("Book is already checked out. Sorry!");
                } else {
                    System.out.println("Book is available.");
                }
            }
        }
        if (!bookFound) {
            System.out.println("No books found with that title.");
        }
    }
}