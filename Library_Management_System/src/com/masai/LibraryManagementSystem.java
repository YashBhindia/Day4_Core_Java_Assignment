package com.masai;

public class LibraryManagementSystem {

	public static void main(String[] args) {
        Library library = new Library();

        // Adding some books to the library
        library.addBook(1, "Java", "Ratan");
        library.addBook(2, "DSA", "Venugopal");
        library.addBook(3, "CSBT", "Loachani");

        // Registering members
        library.registerMember("Yash");
        library.registerMember("Ayush");

        // Checkout and return example
        try {
            library.checkoutBook(1, "Yash");
            library.checkoutBook(2, "Ayush");
            library.returnBook(1);
            library.returnBook(2);
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
