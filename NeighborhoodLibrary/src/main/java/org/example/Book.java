package org.example;

public class Book {
    //Create the Properties
    public int ID;
    public String isbn;
    public String title;
    public boolean isCheckedOut;
    public String checkOutTo;

    //Make constructor
    public Book(int ID, String isbn, String title, boolean isCheckedOut, String checkOutTo) {
        this.ID = ID;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkOutTo = checkOutTo;
    }


    //Make getters and setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckOutTo() {
        return checkOutTo;
    }

    public void setCheckOutTo(String checkOutTo) {
        this.checkOutTo = checkOutTo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkOutTo='" + checkOutTo + '\'' +
                '}';
    }

    //**** create the methods for checkOut and checkIn ****
    //check Out:
    public boolean checkOut(String borrowerName) {
        if (isCheckedOut) {
            isCheckedOut = true;
            checkOutTo = borrowerName;
            return true;
        } else {
            System.out.println("Book is checked out. Thank you!");
            return false;
        }
    }
    //make check-in method:
    public void checkIn(){
        if (isCheckedOut) {
            checkOutTo = "";
            System.out.println("Book successfully checked in. Thank you!");
        } else {
            System.out.println("This book is already checked in");
        }
    }
}