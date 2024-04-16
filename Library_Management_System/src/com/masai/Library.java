package com.masai;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Library {

	private ArrayList<Book> books;
    private LinkedList<String> waitingList;
    private Vector<String> members;
    private Stack<Book> returnedBooks;
    private HashSet<String> uniqueMembers;
    private LinkedHashSet<Book> borrowedBooks;
    private TreeSet<String> sortedBookTitles;
    private HashMap<Integer, Book> bookDetails;
    private LinkedHashMap<Integer, Date> bookCheckouts;
    private TreeMap<Integer, Book> sortedBooksById;

    public Library() {
        books = new ArrayList<>();
        waitingList = new LinkedList<>();
        members = new Vector<>();
        returnedBooks = new Stack<>();
        uniqueMembers = new HashSet<>();
        borrowedBooks = new LinkedHashSet<>();
        sortedBookTitles = new TreeSet<>();
        bookDetails = new HashMap<>();
        bookCheckouts = new LinkedHashMap<>();
        sortedBooksById = new TreeMap<>();
    }

    
    public void addBook(int id, String title, String author) {
        Book book = new Book(id, title, author);
        books.add(book);
        bookDetails.put(id, book);
        sortedBooksById.put(id, book);
        sortedBookTitles.add(title);
    }

    
    public void registerMember(String memberName) {
        if (!uniqueMembers.contains(memberName)) {
            members.add(memberName);
            uniqueMembers.add(memberName);
        }
    }

    
    public void checkoutBook(int bookId, String memberName) throws BookNotAvailableException {
        Book book = bookDetails.get(bookId);
        if (book != null && books.contains(book)) {
            books.remove(book);
            borrowedBooks.add(book);
            bookCheckouts.put(bookId, new Date());
            System.out.println(memberName + " checked out " + book.getTitle());
        } else {
            throw new BookNotAvailableException("Book not available for checkout");
        }
    }

    
    public void returnBook(int bookId) {
        Book book = bookDetails.get(bookId);
        if (book != null && borrowedBooks.contains(book)) {
            books.add(book);
            borrowedBooks.remove(book);
            bookCheckouts.remove(bookId);
            returnedBooks.push(book);
            System.out.println(book.getTitle() + " returned to the library.");
        }
    }
}


    

