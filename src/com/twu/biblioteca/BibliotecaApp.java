package com.twu.biblioteca;

import java.util.Iterator;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public void printWelcome() {
        System.out.println("Welcome to Biblioteca");
    }

    public void listBooks(List<Book> books) {
        System.out.println("The list of Books:");
        Iterator iter = books.iterator();
        while (iter.hasNext()) {
            printBook((Book) iter.next());
        }
    }

    private void printBook(Book book) {
        System.out.println(book.getName()+" "+book.getAuthor()+" "+book.getYearOfPublished());
    }

    public void showMenu(List<String> menu) {
        System.out.println("Choose an option:");
        Iterator iter = menu.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
